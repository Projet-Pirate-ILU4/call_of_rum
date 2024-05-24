package fr.call_of_rum.boundary.dialog;

import java.awt.EventQueue;
import java.util.List;
import java.util.Optional;

import fr.call_of_rum.boundary.IFunctionalKernel;
import fr.call_of_rum.boundary.IGraphicInterface;
import fr.call_of_rum.boundary.presentation.GameFrame;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

import static fr.call_of_rum.util.ItemType.*;

/**
 * 
 * @author Mateo LAFORGE
 */
public class Dialog implements IDialog, IGraphicInterface {
	
	private GameFrame presentation;
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

	@Override
	public CellType[] getCellsType() {
            // TODO modify architecture
            CellType[] cellTypes = new CellType[30];
            for (int i = 0; i < cellTypes.length; i++) {
                cellTypes[i] = functionalKernelAdapter.askCellType(i);
            }
            return cellTypes;
	}

	public boolean buy(ItemType item, Player player) {
		return false;
	}

	@Override
	public int getPrice(ItemType itemType) {
		return 100;
	}

	@Override
	public int getSizeInventaireAvailable(Player player) {
		return 2;
	}

	@Override
	public int checkfound(Player player) {
		return 200;
	}
	

	private boolean isTurnEnded;

	@Override
	public void giveTurn(Player player) {
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
	
	public void endTurn() {
		isTurnEnded = true;
	}

	@Override
	public ItemType[] getItemMarket() {
		ItemType[] itemTypes = new ItemType[4];
		itemTypes[0] = CLOVER;
		itemTypes[1] = BANDANA;
		itemTypes[2] = GUNPOWDER;
		itemTypes[3] = LUCIDITY_STONE;
		return  itemTypes;
	}

	@Override
	public void buy(Player player, List<ItemType> itemTypesSelect) {

	}

	@Override
	public String getNameItem(ItemType itemType) {
		return  itemType.toString();
	}

	@Override
	public String getDescribe(ItemType itemType) {
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit,";
	}

	@Override
	public boolean chestFound(int coinAmount, ItemType itemType) {
		// TODO implements
		return false;
	}

	@Override
	public boolean openedChestFound(int coinAmount, Optional<ItemType> optionalItemType) {
		// TODO implements
		return false;
	}
	
	@Override
	public void useItem(int itemIndex, Player player) {
		// TODO implements
	}
	
	 @Override
	public void throwItem(ItemType itemIndex, Player player) {
		// TODO implements
	}

	@Override
	public String getDescribe2(int itemIndex) {
		return null;
	}


	@Override
	public void print(String s) {

	}

	@Override
	public void showExplosion() {
		// TODO implements
	}

	@Override
	public void showShortcut() {
		// TODO implements
	}

	@Override
	public void showDuel(Player winner) {

	}

	@Override
	public void updateScores() {

	}

	@Override
	public void printMessage(String msg) {
		presentation.printMessage(msg);
	}
	
	@Override
	public void clearMessages() {
		presentation.clearMessages();
	}
	
	@Override
	public void close() {
		presentation.dispose();
	}
        
        @Override
        public ItemType[] getDroppedItems(int cellIndex){
            ItemType[] itemTypes = new ItemType[0];
            return itemTypes;
        }

	@Override
	public ItemType[] getInventory(Player player) {
		ItemType[] itemTypes = {RUM, LUCIDITY_STONE, HEALTH_POTION};
		return itemTypes;
	}

	@Override
        public int getNumberOfDroppedItems(int cellIndex){
            return -1;
        }
        @Override
        public void pickUpItem(int itemIndex){
            return;
        }

	@Override
	public int getPlayerHealth(Player player) {
		return 10;
	}

	@Override
	public ItemType getWeapon(Player player) {
		return MUSKET;
	}

	@Override
	public float getIntoxication(Player player) {
		return 0.5f;
	}


}
