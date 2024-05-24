package fr.call_of_rum.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.Supplier;

import fr.call_of_rum.controller.accessible.IActionController;
import fr.call_of_rum.controller.accessible.IBoardController;
import fr.call_of_rum.controller.accessible.IDiceController;
import fr.call_of_rum.controller.accessible.IMarketController;
import fr.call_of_rum.controller.accessible.IPlayerController;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class ConsoleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	
	private Scanner scan;
	private Player currentPlayer;
	
	private IActionController actionController;
	private IBoardController boardController;
	private IDiceController diceController;
	private IPlayerController playerController;
	
	public ConsoleBoundary() {
		this.scan = new Scanner(System.in);
	}
	
	@Override
	public void subscribeActionController(IActionController actionController) {
		this.actionController = actionController;
	}

	@Override
	public void subscribeBoardController(IBoardController boardController) {
		this.boardController = boardController;
	}

	@Override
	public void subscribeDiceController(IDiceController diceController) {
		this.diceController = diceController;
	}
	
	@Override
	public void subscribeMarketController(IMarketController marketController) {
		// do nothing because ConsoleBoundary does not implements market
	}

	@Override
	public void subscribePlayerController(IPlayerController playerController) {
		this.playerController = playerController;
	}
	
	private static record Option(String name, Runnable procedure, boolean isEnding) {}
	
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
		ItemType[] itemTypes = playerController.getInventoryItems(currentPlayer);
		ItemType t = itemTypes[i];
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
		ItemType[] itemTypes = playerController.getInventoryItems(currentPlayer);
		
		for (int i = 0; i < 3; i++) {
			if (itemTypes[i] != null) {
				final int index = i;
				options.add(new Option(itemTypes[i].toString(), () -> 
					askQuestion("Item Menu", () -> itemOptionsFunction.apply(index))
				, false));
			}
		}
		
		return options;
	};
	
	private final Supplier<List<Option>> cellOptionsSupplier = () -> {
		List<Option> options = new ArrayList<>();
		int currentPlayerCell = playerController.getLocation(currentPlayer);
		ItemType[] droppedItems = boardController.getDroppedItems(currentPlayerCell);
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
				System.out.println(String.format(bundle.getString("moved"), diceResult, (playerController.getLocation(currentPlayer) + diceResult) % 30));
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
	
	private boolean hasMoved;
	
	// use of supplier to ensure no side-effects
	// possibility for an option to alter the options proposed
	private final Supplier<List<Option>> turnOptionsSupplier = () -> 
		hasMoved ? movedTurnOptions : notMovedTurnOptions
	;
	
	@Override
	public void giveTurn(Player player) {
		hasMoved = false;
		currentPlayer = player;
		System.out.println(String.format(bundle.getString("your_turn"), player));
		askQuestion("Turn Menu", turnOptionsSupplier);
		System.out.println();
    }
	
	private boolean takeChestItemQuestion(ItemType itemType) {
		System.out.println(bundle.getString("loot_chest_question"));
		System.out.print("[y/n]");
		String input;
		input = scan.nextLine();
		if (input.equalsIgnoreCase("y")) {
			System.out.println(String.format(bundle.getString("took_item"), bundle.getString(itemType.toString().toLowerCase())));
			return true;
		}
		return false;
	}
	
	@Override
	public boolean chestFound(int coinAmount, ItemType itemNamespace) {
		System.out.println(bundle.getString("chest_found"));
		System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, itemNamespace.toString()));
		return takeChestItemQuestion(itemNamespace);
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<ItemType> optionalItemType) {
		System.out.println(bundle.getString("opened_chest_found"));
		if (optionalItemType.isPresent()) {
			System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, bundle.getString(optionalItemType.get().toString().toLowerCase())));
			return takeChestItemQuestion(optionalItemType.get());
		} else {
			System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, bundle.getString("no_item")));
			return false;
		}
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
	public void duel(Player winner) {
		System.out.println(String.format(bundle.getString("duel"), winner.toString()));
		System.out.println(String.format(bundle.getString("show_health"), playerController.getHealth(currentPlayer), playerController.getMaxHealth(currentPlayer)));
		System.out.println(String.format(bundle.getString("show_score"), playerController.getCoins(currentPlayer)));
	}
	
	@Override
	public void gameEnded(Player winner) {
		System.out.printf(bundle.getString("game_ended"), winner);
	}
	
}
