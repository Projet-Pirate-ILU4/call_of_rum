package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.call_of_rum.controller.IBoardController;
import fr.call_of_rum.controller.IMoveController;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.Player;

public class FunctionalKernelAdapter implements IBoundary, IFunctionalKernel {
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.ENGLISH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);
	
	/*****************************
	*  Notifications (upcalls)   *
	*****************************/
	
	private IGraphicInterface graphicInterface;
	
	public void setGraphicInterface(IGraphicInterface graphicInterface) {
		this.graphicInterface = graphicInterface;
	}
	
	@Override
	public void giveTurn(Player player) {
		graphicInterface.giveTurn(player);
		graphicInterface.printMessage(String.format(bundle.getString("your_turn"), player));
	}
	
	@Override
	public void stepOnBomb() {
		graphicInterface.showExplosion();
	}
	
	@Override
	public void tookShortcut() {
		graphicInterface.showShortcut();
	}
	
	@Override
	public void chestFound(int coinAmount, String itemNamespace) {
		graphicInterface.showChest(coinAmount, itemNamespace);
	}

	@Override
	public void openedChestFound(int coinAmount, Optional<String> itemNamespace) {
		graphicInterface.showOpenedChest(coinAmount, itemNamespace);
	}

	@Override
	public void gameEnded(Player winner) {
		graphicInterface.printMessage(String.format(bundle.getString("game_ended"), winner));
		graphicInterface.close();
	}
	
	/*****************************
	*    Requests (downcalls)    *
	*****************************/
	
	private IBoardController boardController;
	private IMoveController moveController;
	
	public void setBoardController(IBoardController boardController) {
		this.boardController = boardController;
	}
	
	public void setMoveController(IMoveController moveController) {
		this.moveController = moveController;
	}

	@Override
	public CellType askCellType(int numCell) {
		return boardController.getCellType(numCell);
	}

}
