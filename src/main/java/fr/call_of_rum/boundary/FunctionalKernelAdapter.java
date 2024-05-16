package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.BoardController;
import fr.call_of_rum.controller.accessible.MoveController;
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
	
	private BoardController boardController;
	private MoveController moveController;
	private ActionController actionController;
	
	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}
	
	public void setMoveController(MoveController moveController) {
		this.moveController = moveController;
	}
	
	public void setActionController(ActionController actionController) {
		this.actionController = actionController;
	}

	@Override
	public CellType askCellType(int numCell) {
		return boardController.getCellType(numCell);
	}

}
