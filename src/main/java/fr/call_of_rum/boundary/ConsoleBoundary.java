package fr.call_of_rum.boundary;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

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
	
	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}
	
	public void setDiceController(DiceController diceController) {
		this.diceController = diceController;
	}
	
	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}
	
	private void showItemMenu(boolean hasUse) {
		if (hasUse) {
			System.out.println("=== Item Menu ===");
			System.out.println("1. examine");
			System.out.println("2. drop");
			System.out.println("0. exit");
		} else {
			System.out.println("=== Item Menu ===");
			System.out.println("1. examine");
			System.out.println("2. use");
			System.out.println("3. drop");
			System.out.println("0. exit");
		}
	}
	
	private void openItemMenu(ItemType itemType) {
		boolean hasUse = itemType == ItemType.CLOVER || itemType == ItemType.BANDANA || itemType == ItemType.GUNPOWDER;
		boolean exit = false;
		while (!exit) {
			showItemMenu(hasUse);
			int choice = getUserChoice();
			switch (choice) {
				case 1:
					System.out.println("Not implemented");
					break;
				case 2:
					System.out.println("Not implemented");
					break;
				case 3:
					System.out.println("Not implemented");
					break;
				case 0:
					exit = true;
					break;
				default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
			}
		}
	}
	
	private void showInventoryMenu() {
		System.out.println("=== Inventory Menu ===");
		System.out.println("1. " + playerController.getItemType(0));
		System.out.println("2. " + playerController.getItemType(1));
		System.out.println("3. " + playerController.getItemType(1));
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
    }
	
	private void openInventoryMenu() {
		for (int i = 0; i < 3; i++) {
			System.out.println(playerController.getItemType(i));
		}
		
		boolean exit = false;
		while (!exit) {
			showInventoryMenu();
			int choice = getUserChoice();
			switch (choice) {
				case 1:
					openItemMenu(playerController.getItemType(0));
					break;
				case 2:
					openItemMenu(playerController.getItemType(1));
					break;
				case 3:
					openItemMenu(playerController.getItemType(2));
					break;
				case 0:
					exit = true;
					break;
				default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
			}
		}
	}
	
	private boolean hasMoved = false;

    private void showMainMenu() {
    	if (hasMoved) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
    	} else {
            System.out.println("=== Main Menu ===");
            System.out.println("1. move");
            System.out.println("2. go to merchant");
            System.out.println("3. inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
    	}
    }
	
	@Override
	public void giveTurn(Player player) {
		hasMoved = false;
		currentPlayer = player;
		System.out.println(String.format(bundle.getString("your_turn"), player));
		boolean exit = false;

        while (!exit) {
            showMainMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                	if (hasMoved) {
                		openInventoryMenu();
                		break;
                	}
                    int diceResult = diceController.getDiceResult();
                    System.out.println(String.format(bundle.getString("moved"),
                    		diceResult,
                    		(boardController.getPirateCellNumber(player) + diceResult) % 30
                    		));
                    actionController.move();
                    hasMoved = true;
                    break;
                case 2:
                	if (hasMoved) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                	}
                	// TODO implements go to merchant
                	System.out.println("Not implemented");
                    break;
                case 3:
                	if (hasMoved) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                	}
                    openInventoryMenu();
                	break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
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
