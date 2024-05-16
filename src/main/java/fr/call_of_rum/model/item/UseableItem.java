package fr.call_of_rum.model.item;

public abstract class UseableItem extends Item {

	private int price;


	protected UseableItem(String namespace) {
		super(namespace);
	}

	public abstract void use();

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
