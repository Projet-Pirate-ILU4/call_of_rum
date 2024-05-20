package fr.call_of_rum.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.Supplier;

import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.BoardController;
import fr.call_of_rum.controller.accessible.DiceController;
import fr.call_of_rum.controller.accessible.PlayerController;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class ConsoleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	
	private Scanner scan;
	private Player currentPlayer;
	
	private ActionController actionController;
	private PlayerController playerController;
	private DiceController diceController;
	private BoardController boardController;
	
	public ConsoleBoundary() {
		this.scan = new Scanner(System.in);
	}
	
	public void setActionController(ActionController actionController) {
		this.actionController = actionController;
	}
	
	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}
	
	public void setDiceController(DiceController diceController) {
		this.diceController = diceController;
	}
	
	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}
	
	private static record Option(String name, Runnable procedure, boolean isEnding) {}
	
	// TODO push and make so text is dynamic (inventory not being up-to-date when dropping)
	
	private void askQuestion(String title, Supplier<List<Option>> optionsSupplier) {
		int choice;
		do {
			List<Option> options = optionsSupplier.get();
			System.out.println("=== " + title + " ===");
			for (int i = 0; i < options.size(); i++) {
				System.out.println((i + 1) + ": " + options.get(i).name());
			}
			System.out.println("0: Exit");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			scan.nextLine(); // consume newline character
			if (choice > 0 && choice <= options.size()) {
				options.get(choice - 1).procedure().run();
				if (options.get(choice - 1).isEnding()) break;
			} else if (choice != 0) {
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}
	
	// use of supplier to ensure no side-effects
	private final IntFunction<List<Option>> itemOptionsFunction = i -> {
		ItemType t = playerController.getItemType(i);
		List<Option> options = new ArrayList<>();
		options.add(new Option("examine", () -> {
			String namespace = t.toString().toLowerCase();
			System.out.print(namespace);
			System.out.print(": ");
			System.out.println(bundle.getString(namespace + "_description"));
		}, false));
		if (t != ItemType.CLOVER && t != ItemType.BANDANA && t != ItemType.GUNPOWDER) {
			options.add(new Option("use", () -> {
				// TODO implements use
			}, false));
		}
		options.add(new Option("drop", () -> actionController.dropItem(i), true));
		return options;
	};
	
	// use of supplier to ensure that the presented inventory is up-to-date
	private final Supplier<List<Option>> inventoryOptionsSupplier = () -> {
		List<Option> options = new ArrayList<>();
		ItemType itemType;
		
		for (int i = 0; i < 3; i++) {
			itemType = playerController.getItemType(i);
			if (itemType != null) {
				final int index = i;
				options.add(new Option(itemType.toString(), () -> 
					askQuestion("Item Menu", () -> itemOptionsFunction.apply(index))
				, false));
			}
		}
		
		return options;
	};
	
	private final Supplier<List<Option>> cellOptionsSupplier = () -> {
		List<Option> options = new ArrayList<>();
		ItemType[] droppedItems = boardController.getDroppedItems();
		ItemType itemType;
		
		for (int i = 0; i < droppedItems.length; i++) {
			itemType = droppedItems[i];
			final int index = i;
			options.add(new Option(itemType.toString(), () -> 
				actionController.pickUpItem(index)
			, false));
		}
		
		return options;
	};
	
	private final Option inventoryOption = new Option("inventory", () ->
			askQuestion("Inventory Menu", inventoryOptionsSupplier)
		, false);
	
	private final Option lookCellOption = new Option("look cell", () ->
			askQuestion("Cell Menu", cellOptionsSupplier)
		, false);
	
	private final List<Option> notMovedTurnOptions = List.of(
			new Option("move", () -> {
				int diceResult = diceController.getDiceResult();
				System.out.println(String.format(bundle.getString("moved"), diceResult, (boardController.getPirateCellNumber(currentPlayer) + diceResult) % 30));
				actionController.move();
				hasMoved = true;
				}, false),
			
			new Option("move to merchant", () -> {
				System.out.println("Not Implemented");
				hasMoved = true;
				}, false),
			
			inventoryOption,
			lookCellOption
		);
	
	private final List<Option> movedTurnOptions = List.of(
			inventoryOption,
			lookCellOption
		);
	
	private boolean hasMoved = false;
	
	// use of supplier to ensure no side-effects
	// possibility for an option to alter the options proposed
	private final Supplier<List<Option>> turnOptionsSupplier = () -> {
		return hasMoved ? movedTurnOptions : notMovedTurnOptions;
	};
	
	@Override
	public void giveTurn(Player player) {
		currentPlayer = player;
		System.out.println(String.format(bundle.getString("your_turn"), player));
		askQuestion("Turn Menu", turnOptionsSupplier);
		System.out.println();
    }
	
	private boolean takeChestItemQuestion(String itemNamespace) {
		System.out.println(bundle.getString("loot_chest_question"));
		System.out.print("[y/n]");
		String input;
		input = scan.nextLine();
		if (input.equalsIgnoreCase("y")) {
			System.out.println(String.format(bundle.getString("took_item"), bundle.getString(itemNamespace)));
			return true;
		}
		return false;
	}
	
	@Override
	public boolean chestFound(int coinAmount, String itemNamespace) {
		System.out.println(bundle.getString("chest_found"));
		System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, itemNamespace));
		return takeChestItemQuestion(itemNamespace);
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<String> itemNamespace) {
		System.out.println(bundle.getString("opened_chest_found"));
		String namespace;
		if (itemNamespace.isEmpty()) {
			namespace = "no_item";
		} else {
			namespace = itemNamespace.get();
		}
		System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, bundle.getString(namespace)));
		if (!itemNamespace.isEmpty())
			return takeChestItemQuestion(namespace);
		return false;
	}

	@Override
	public void stepOnBomb() {
		System.out.println(bundle.getString("step_on_bomb"));
		System.out.println(String.format(bundle.getString("show_health"), playerController.getHealth(currentPlayer), playerController.getMaxHealth(currentPlayer)));
	}

	@Override
	public void tookShortcut() {
		System.out.println(bundle.getString("took_shortcut"));
	}
	
	@Override
	public void gameEnded(Player winner) {
		System.out.printf(bundle.getString("game_ended"), winner);
	}
	
}
