package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.call_of_rum.controller.accessible.MoveController;
import fr.call_of_rum.util.Player;

public class ConsoleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	private Scanner scan;
	
	public ConsoleBoundary() {
		this.scan = new Scanner(System.in);
	}
	
	private MoveController moveController;
	
	public void setMoveController(MoveController moveContorller) {
		this.moveController = moveContorller;
	}
	
	private int i = 0;
	
	@Override
	public void giveTurn(Player player) {
		System.out.println(String.format(bundle.getString("your_turn"), player));
		String input;
		do {
			input = scan.next();
		} while(!input.equals("q"));
		System.out.println("move 4");
		moveController.movePlayer(player, ++i);
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
