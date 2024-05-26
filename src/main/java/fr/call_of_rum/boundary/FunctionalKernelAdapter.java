package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.call_of_rum.controller.accessible.IActionController;
import fr.call_of_rum.controller.accessible.IBoardController;
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
	public boolean chestFound(int coinAmount, ItemType itemType) {
		return graphicInterface.chestFound(coinAmount, itemType);
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<ItemType> optionalItemType) {
		return graphicInterface.openedChestFound(coinAmount, optionalItemType);
	}
	
	@Override
	public void duel(Player winner) {
		graphicInterface.showDuel(winner);
		graphicInterface.updateScores();
	}
	
	@Override
	public void duel(Player winner) {
		graphicInterface.showDuel(winner);
		graphicInterface.updateScores();
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
	private IActionController actionController;
	
	public void setBoardController(IBoardController boardController) {
		this.boardController = boardController;
	}
	
	public void setActionController(IActionController actionController) {
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
	public boolean buyItem(int itemIndex) {
		return actionController.buyItem(itemIndex);
	}

	@Override
	public boolean drink(int itemIndex) {
		return actionController.drink(itemIndex);
	}

	@Override
	public boolean equipWeapon(int itemIndex) {
		return actionController.equipWeapon(itemIndex);
	}

	@Override
	public boolean pickUpItem(int itemIndex) {
		return actionController.pickUpItem(itemIndex);
	}

	@Override
	public boolean dropItem(int itemIndex) {
		return actionController.dropItem(itemIndex);
	}

	@Override
	public boolean move() {
		return actionController.move();
	}

}
