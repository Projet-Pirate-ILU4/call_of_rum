package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.PlayerItemController;
import fr.call_of_rum.util.Player;

public class ConsoleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	private Scanner scan;
	
	private ActionController actionController;
	private PlayerItemController playerItemController;
	
	public ConsoleBoundary() {
		this.scan = new Scanner(System.in);
	}

    private int getUserChoice() {
        int choice = -1;
        if (scan.hasNextInt()) {
            choice = scan.nextInt();
        }
        scan.nextLine(); // consume the newline character
        return choice;
    }
	
	public void setActionController(ActionController actionController) {
		this.actionController = actionController;
	}
	
	public void setPlayerInventoryController(PlayerItemController playerItemController) {
		this.playerItemController = playerItemController;
	}
	
	private void openInventoryMenu() {
		for (int i = 0; i < 3; i++) {
			System.out.println(playerItemController.getItemType(i));
		}
		
		boolean exit = false;
		System.out.println("enter");
		int choice = getUserChoice();
		System.out.println(choice);
	}

    private void showMainMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("1. move");
        System.out.println("2. inventory");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
	
	@Override
	public void giveTurn(Player player) {
		System.out.println(String.format(bundle.getString("your_turn"), player));
		boolean exit = false;

        while (!exit) {
            showMainMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    actionController.move();
                    break;
                case 2:
                    openInventoryMenu();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
	
	private void takeChestItem(String itemNamespace) {
		System.out.println(bundle.getString("loot_chest_question"));
		System.out.print("[y/n]");
		String input;
		input = scan.next();
		if (input.equalsIgnoreCase("y")) {
			System.out.println(String.format(bundle.getString("took_item"), bundle.getString(itemNamespace)));
		}
	}
	
	@Override
	public void chestFound(int coinAmount, String itemNamespace) {
		System.out.println(bundle.getString("chest_found"));
		System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, itemNamespace));
		System.out.println(bundle.getString("loot_chest_question"));
	}

	@Override
	public void openedChestFound(int coinAmount, Optional<String> itemNamespace) {
		System.out.println(bundle.getString("opened_chest_found"));
		String namespace;
		if (itemNamespace.isEmpty()) {
			namespace = "no_item";
		} else {
			namespace = itemNamespace.get();
		}
		System.out.println(String.format(bundle.getString("chest_prompt"), coinAmount, bundle.getString(namespace)));
		if (!itemNamespace.isEmpty())
			takeChestItem(namespace);
	}

	@Override
	public void stepOnBomb() {
		System.out.println(bundle.getString("step_on_bomb"));
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
