package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	private Scanner scan;
	
	public ConsoleBoundary() {
		this.scan = new Scanner(System.in);
	}
	
	@Override
	public void giveTurn(int player) {
		System.out.println(String.format(bundle.getString("your_turn"), player));
		String input;
		do {
			input = scan.next();
		} while(!input.equals("q"));
	}
	
	@Override
	public void gameEnded(int winner) {
		System.out.printf(bundle.getString("game_ended"), winner);
	}
	
}
