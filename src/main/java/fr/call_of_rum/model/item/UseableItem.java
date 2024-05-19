package fr.call_of_rum.model.item;

import fr.call_of_rum.util.ItemType;

public abstract class UseableItem extends Item {

	private int price;


	protected UseableItem(ItemType itemType) {
		super(itemType);
	}

	public abstract void use();

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
