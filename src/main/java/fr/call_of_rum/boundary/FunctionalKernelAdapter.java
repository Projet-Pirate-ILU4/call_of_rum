package fr.call_of_rum.boundary;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.call_of_rum.controller.accessible.IActionController;
import fr.call_of_rum.controller.accessible.IBoardController;
import fr.call_of_rum.controller.accessible.IDiceController;
import fr.call_of_rum.controller.accessible.IMarketController;
import fr.call_of_rum.controller.accessible.IPlayerController;
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

	private IActionController actionController;
	private IBoardController boardController;
	private IDiceController diceController;
	private IMarketController marketController;
	private IPlayerController playerController;

	@Override
	public void subscribeActionController(IActionController actionController) {
		this.actionController = actionController;
	}
	
	@Override
	public void subscribeBoardController(IBoardController boardController) {
		this.boardController = boardController;
	}

	@Override
	public void subscribeDiceController(IDiceController diceController) {
		this.diceController = diceController;
	}

	@Override
	public void subscribeMarketController(IMarketController marketController) {
		this.marketController = marketController;
	}

	@Override
	public void subscribePlayerController(IPlayerController playerController) {
		this.playerController = playerController;
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

	@Override
	public ItemType[] getItemsForSale() {
		return marketController.getItemForSale();
	}

	@Override
	public int getPrice(int itemIndex) {
		return marketController.getPrice(itemIndex);
	}

	@Override
	public int getScore(Player player) {
		return playerController.getCoins(player);
	}

	@Override
	public ItemType[] getInventory(Player player) {
		return playerController.getInventoryItems(player);
	}

	@Override
	public int getHealth(Player player) {
		return playerController.getHealth(player);
	}

	@Override
	public int getMaxHealth(Player player) {
		return playerController.getMaxHealth(player);
	}

	@Override
	public ItemType getWeapon(Player player) {
		return playerController.getEquippedWeapon(player);
	}

	@Override
	public float getIntoxication(Player player) {
		return playerController.getIntoxicationLevel(player);
	}

	@Override
	public int getDicesResult() {
		return diceController.getDiceResult();
	}

}
