package fr.call_of_rum.model.market;

import java.util.function.Supplier;

import fr.call_of_rum.model.item.Item;

public class ItemStock {
	
	private final Supplier<Item> supplier;
	private int price;
	
	public ItemStock(Supplier<Item> supplier, int price) {
		this.supplier = supplier;
		this.price = price;
	}
	
	public Item getItem() {
		return supplier.get();
	}
	
	public int getPrice() {
		return price;
	}
	
}
