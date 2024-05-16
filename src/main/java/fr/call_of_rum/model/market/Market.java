package fr.call_of_rum.model.market;

import java.util.Collection;

import fr.call_of_rum.model.item.UseableItem;
import fr.call_of_rum.model.pirate.Inventory;

public class Market {
	
	private static final int NUMBER_OF_ITEMS = 4;
	
	private Inventory<UseableItem> inventory = new Inventory<>(NUMBER_OF_ITEMS);
	
	public Market(Collection<UseableItem> items) {
		for (UseableItem item : items) {
			items.add(item);
		}
	}
	
	public UseableItem getItem(int itemIndex) {
		return inventory.get(itemIndex);
	}
	
}
