package fr.call_of_rum.model.board.cells;

import fr.call_of_rum.model.item.Item;

public class Chest extends Cell {
	
	private int coins;
	private Item item;
	
	public Chest(int num, int coins, Item item) {
		super(num);
		this.coins = coins;
		this.item = item;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public Item getItem() {
		return item;
	}
	
}
