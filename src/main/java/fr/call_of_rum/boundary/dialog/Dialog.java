package fr.call_of_rum.boundary.dialog;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.call_of_rum.boundary.IFunctionalKernel;
import fr.call_of_rum.boundary.IGraphicInterface;
import fr.call_of_rum.boundary.presentation.GameFrame;
import fr.call_of_rum.boundary.presentation.Presentation;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

/**
 * 
 * @author Mateo LAFORGE
 */
public class Dialog implements IDialog, IGraphicInterface {
	
	private Presentation presentation;
	private IFunctionalKernel functionalKernelAdapter;
	
	public Dialog(IFunctionalKernel functionalKernelAdapter) {
		this.functionalKernelAdapter = functionalKernelAdapter;
		this.presentation = new GameFrame(this);
	}

	public Dialog() {

	}

	public void initDialog() {
		EventQueue.invokeLater(() -> this.presentation.setVisible(true));
	}
	
	private boolean isTurnEnded;
	private Player currentPlayer;
	
	/*****************************
	*  Notifications (upcalls)   *
	*****************************/

	@Override
	public void giveTurn(Player player) {
		currentPlayer = player;
		if (player == Player.JACK_LE_BORGNE) {
			presentation.enableFirstPlayer();
		} else {
			presentation.enableSecondPlayer();
		}
		isTurnEnded = false;
		synchronized (presentation) {
			while (!isTurnEnded) {
                try {
                    presentation.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    // Handle interruption
                }
            }
		}
	}

	@Override
	public boolean chestFound(int coinAmount, ItemType itemType) {
		return presentation.chestFound(coinAmount, itemType);
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<ItemType> optionalItemType) {
		return presentation.openedChestFound(coinAmount, optionalItemType);
	}


	@Override
	public void print(String s) {
		this.printMessage(s);
	}

	@Override
	public void showExplosion() {
		presentation.showExplosion();
	}

	@Override
	public void showShortcut() {
		presentation.showShortcut();
	}

	@Override
	public void showDuel(Player winner) {
		presentation.showDuel(winner);
	}

	@Override
	public void updateScores() {
		presentation.updateScores();
	}

	@Override
	public void printMessage(String msg) {
		presentation.printMessage(msg);
	}
	
	@Override
	public void clearMessages() {
		presentation.clearMessages();
	}
	
	/*****************************
	*    Requests (downcalls)    *
	*****************************/
	
	// ### ACTIONS ###
	
	@Override
	public boolean buy(int itemIndex) {
		return functionalKernelAdapter.buyItem(itemIndex);
	}
	
	@Override
	public boolean drink(Player player, int itemIndex) {
		if (player != currentPlayer) return false;
		return true;
	}
	
	@Override
	public boolean equip(Player player, int itemIndex) {
		if (player != currentPlayer) return false;
		return functionalKernelAdapter.equipWeapon(itemIndex);
	}
	
	 @Override
	public boolean dropItem(Player player, int itemIndex) {
		if (player != currentPlayer) return false;
		boolean succeded = functionalKernelAdapter.dropItem(itemIndex);
		if (succeded) {
			presentation.notifyDrop(this.getInventory(player)[itemIndex]);
		}
		return succeded;
	}
	
	 @Override
	public boolean pickUpItem(int itemIndex) {
		boolean succeded = functionalKernelAdapter.pickUpItem(itemIndex);
		if (succeded) {
			presentation.notifyPickUp(this.getInventory(currentPlayer)[itemIndex]);
		}
		return succeded;
	}

	@Override
	public boolean move() {
		return functionalKernelAdapter.move();
	}
	
	// ### INFORMATIONS ###
	
	@Override
	public CellType[] getCellsType() {
		CellType[] cellTypes = new CellType[30];
		for (int i = 0; i < cellTypes.length; i++) {
			cellTypes[i] = functionalKernelAdapter.askCellType(i);
		}
		return cellTypes;
	}
	
	@Override
	public ItemType[] getDroppedItems(int cellIndex){
		return functionalKernelAdapter.getDroppedItems(cellIndex);
	}

	@Override
	public int getNumberOfDroppedItems(int cellIndex){
		return functionalKernelAdapter.getNumberOfDroppedItems(cellIndex);
	}

	@Override
	public ItemType[] getMarketItems() {
		return functionalKernelAdapter.getItemsForSale();
	}

	@Override
	public int getPrice(int itemIndex) {
		return functionalKernelAdapter.getPrice(itemIndex);
	}

	@Override
	public int getNumberOfFreeSlots() {
		ItemType[] inventory = this.getInventory(currentPlayer);
		return (int) Arrays.stream(inventory).filter(i -> i == null).count();
	}

	@Override
	public int checkfunds(Player player) {
		return functionalKernelAdapter.getScore(player);
	}

	@Override
	public ItemType[] getInventory(Player player) {
		return functionalKernelAdapter.getInventory(player);
	}

	@Override
	public int getPlayerHealth(Player player) {
		return functionalKernelAdapter.getHealth(player);
	}
	
	@Override
	public int getPlayerMaxHealth(Player player) {
		return functionalKernelAdapter.getMaxHealth(player);
	}

	@Override
	public ItemType getWeapon(Player player) {
		return functionalKernelAdapter.getWeapon(player);
	}

	@Override
	public float getIntoxication(Player player) {
		return functionalKernelAdapter.getIntoxication(player);
	}

	@Override
	public int getDicesResult() {
		return functionalKernelAdapter.getDicesResult();
	}

	@Override
	public boolean isLiquid(ItemType itemType) {
		return itemType == ItemType.HEALTH_POTION || itemType == ItemType.RUM;
	}

	@Override
	public boolean isWeapon(ItemType itemType) {
		return itemType == ItemType.DAGGER ||
				itemType == ItemType.FLINTLOCK_PISTOL ||
				itemType == ItemType.MUSKET ||
				itemType == ItemType.SABER;
	}
	
	private static final String LANGUAGE_BASE_FILENAME = "messages";
	private static final Locale LOCALE = Locale.FRENCH;
	
	// language bundle
	private ResourceBundle bundle = ResourceBundle.getBundle(LANGUAGE_BASE_FILENAME, LOCALE);

	@Override
	public String getItemName(ItemType itemType) {
		return bundle.getString(itemType.toString().toLowerCase());
	}

	@Override
	public String getItemDescription(ItemType itemType) {
		return bundle.getString(itemType.toString().toLowerCase() + "_description");
	}
	
	@Override
	public void close() {
		presentation.dispose();
	}
	
	@Override
	public void endTurn() {
		isTurnEnded = false;
	}

	@Override
	public Player getPlayer2() {
		return Player.BILL_JAMBE_DE_BOIS;
	}

	@Override
	public Player getPlayer1() {
		return Player.BILL_JAMBE_DE_BOIS;
	}

}
