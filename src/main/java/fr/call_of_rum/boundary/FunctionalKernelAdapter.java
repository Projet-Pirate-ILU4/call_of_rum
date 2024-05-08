package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.ResourceBundle;

import fr.call_of_rum.util.CellType;

public class FunctionalKernelAdapter implements IBoundary, IFunctionalKernel {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	
	private IGraphicInterface graphicInterface;
	
	public void setGraphicInterface(IGraphicInterface graphicInterface) {
		this.graphicInterface = graphicInterface;
	}

	@Override
	public CellType askCellType(int numCell) {
		return null;
	}
	
	@Override
	public void giveTurn(int player) {
		graphicInterface.giveTurn(player);
		graphicInterface.printMessage(String.format(bundle.getString("your_turn"), player));
	}

	@Override
	public void gameEnded(int winner) {
		graphicInterface.printMessage(String.format(bundle.getString("game_ended"), winner));
		graphicInterface.close();
	}

}
