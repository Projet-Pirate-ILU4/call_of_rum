package fr.call_of_rum.model.board.cells;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.CellType;

public class ChestCell extends Cell {
	
	private boolean opened = false;
	private int coins;
	private Item item;
	
	public ChestCell(int num, int coins, Item item) {
		super(num);
		this.coins = coins;
		this.item = item;
	}
	
	public boolean isOpened() {
		return opened;
	}
	
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int newAmount) {
		coins = newAmount;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item newItem) {
		item = newItem;
	}

	@Override
	public CellType getType() {
		return opened ? CellType.OPENED_CHEST : CellType.CHEST;
	}
	
}
