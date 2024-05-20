package fr.call_of_rum.model.market;

import java.util.function.Supplier;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.ItemType;

public class ItemStock {
	
	private final Supplier<Item> supplier;
	private ItemType itemType;
	private int price;
	
	public ItemStock(Supplier<Item> supplier, ItemType itemType, int price) {
		this.supplier = supplier;
		this.itemType = itemType;
		this.price = price;
	}
	
	public Item getItem() {
		return supplier.get();
	}
	
	public ItemType getType() {
		return itemType;
	}
	
	public int getPrice() {
		return price;
	}
	
}
