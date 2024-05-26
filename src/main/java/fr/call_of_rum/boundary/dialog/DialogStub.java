
package fr.call_of_rum.boundary.dialog;

import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class DialogStub implements IDialog {

	@Override
	public boolean buy(int itemIndex) {
		return true;
	}

	@Override
	public boolean drink(Player player, int itemIndex) {
		return true;
	}

	@Override
	public boolean equip(Player player, int itemIndex) {
		return true;
	}

	@Override
	public boolean dropItem(Player player, int itemIndex) {
		return true;
	}

	@Override
	public boolean pickUpItem(int itemIndex) {
		return true;
	}

	@Override
	public boolean move() {
		return true;
	}

	@Override
	public CellType[] getCellsType() {
		CellType[] cellType = new CellType[30];
		for (int i = 0; i < 30; i++) {
			cellType[i] = CellType.NORMAL;
		}
		return cellType;
	}

	@Override
	public ItemType[] getDroppedItems(int cellIndex) {
		return new ItemType[] {ItemType.CLOVER};
	}

	@Override
	public int getNumberOfDroppedItems(int cellIndex) {
		return 1;
	}

	@Override
	public ItemType[] getMarketItems() {
		return new ItemType[] {ItemType.HEALTH_POTION, ItemType.FLINTLOCK_PISTOL, ItemType.RUM, ItemType.SABER};
	}

	@Override
	public int getPrice(int itemIndex) {
		return 75;
	}

	@Override
	public int getNumberOfFreeSlots() {
		return 2;
	}

	@Override
	public int checkfunds(Player player) {
		return 1000;
	}

	@Override
	public ItemType[] getInventory(Player player) {
		if (player.equals(Player.JACK_LE_BORGNE)) {
			return new ItemType[] {ItemType.RUM, null, null};
		}
		return new ItemType[] {ItemType.LUCIDITY_STONE, ItemType.GUNPOWDER, null};
	}

	@Override
	public int getPlayerHealth(Player player) {
		return 9;
	}

	@Override
	public int getPlayerMaxHealth(Player player) {
		if (player.equals(Player.JACK_LE_BORGNE)) {
			return 15;
		}
		return 10;
	}

	@Override
	public ItemType getWeapon(Player player) {
		if (player.equals(Player.JACK_LE_BORGNE)) {
			return ItemType.MUSKET;
		}
		return ItemType.DAGGER;
	}

	@Override
	public float getIntoxication(Player player) {
		return 0.1f;
	}

	@Override
	public int getFirstDiceResult() {
		return 2;
	}

	@Override
	public int getSecondDiceResult() {
		return 4;
	}

        @Override
        public void notifyDicesThrown(boolean choice){
            
        }
        
	@Override
	public int getDicesResult() {
		return 6;
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

	@Override
	public String getItemName(ItemType itemType) {
		return itemType.toString();
	}

	@Override
	public String getItemDescription(ItemType itemType) {
		return "lorem ipsum";
	}

	@Override
	public void print(String s) {
		System.out.println(s);
	}

	@Override
	public void endTurn() {
		// do nothing
	}

	public Player getPlayer2() {
		return Player.JACK_LE_BORGNE;
	}

	@Override
	public Player getPlayer1() {
		return Player.BILL_JAMBE_DE_BOIS;
	}

	@Override
	public Player getDuelWinner() {
		return Player.JACK_LE_BORGNE;
	}

}
