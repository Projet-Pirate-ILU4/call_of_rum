package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.BoardController;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
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
	public boolean chestFound(int coinAmount, String itemNamespace) {
		return graphicInterface.chestFound(coinAmount, itemNamespace);
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<String> itemNamespace) {
		return graphicInterface.openedChestFound(coinAmount, itemNamespace);
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
	private ActionController actionController;
	
	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}
	
	public void setActionController(ActionController actionController) {
		this.actionController = actionController;
	}

	@Override
	public CellType askCellType(int numCell) {
		return boardController.getCellType(numCell);
	}

	@Override
	public ItemType[] getDroppedItems(int numCell) {
		return boardController.getDroppedItems(numCell);
	}
	
	@Override
	public int getNumberOfDroppedItems(int numCell) {
		return boardController.getNumberOfDroppedItems(numCell);
	}

	@Override
	public void buyItem(int itemIndex) {
		actionController.buyItem(itemIndex);
	}

	@Override
	public void drink(int itemIndex) {
		actionController.drink(itemIndex);
	}

	@Override
	public void equipWeapon(int itemIndex) {
		actionController.equipWeapon(itemIndex);
	}

	@Override
	public void pickUpItem(int itemIndex) {
		actionController.pickUpItem(itemIndex);
	}

	@Override
	public void dropItem(int itemIndex) {
		actionController.dropItem(itemIndex);
	}

	@Override
	public void move() {
		actionController.move();
	}

}
