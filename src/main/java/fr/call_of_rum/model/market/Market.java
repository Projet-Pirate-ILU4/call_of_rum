package fr.call_of_rum.model.market;

import fr.call_of_rum.model.item.Item;

public class Market {

	private ItemStock[] items;
	
	public Market(ItemStock... items) {
		this.items = items;
	}
	
	public ItemStock[] getItemsForSale() {
		return items;
	}
	
	public int getNumberOfItems() {
		return items.length;
	}
	
	public Item getItem(int itemIndex) {
		return items[itemIndex].getItem();
	}
	
	public int getPrice(int itemIndex) {
		return items[itemIndex].getPrice();
	}
	
}
