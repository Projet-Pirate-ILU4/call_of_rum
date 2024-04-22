package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.ResourceBundle;

import fr.call_of_rum.controller.IDownCall;

public class ExampleBoundary implements IBoundary {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle;
	
	private IDownCall downcallController;
	// and every controller needed to implements IFunctionalKernel
	
	public void setDownCallController(IDownCall downcallController) {
		this.downcallController = downcallController;
		this.bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	}
	
	@Override
	public void upcall() {
		System.out.println(bundle.getString("upcall"));
	}
	
	public void launch() {
		System.out.println("Appplication has been started");
		downcallController.downcall();
	}

}
