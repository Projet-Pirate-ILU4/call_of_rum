package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);

	@Override
	public void gameEnded(int winner) {
		System.out.printf(bundle.getString("gameEnded"), winner);
	}
	
}
