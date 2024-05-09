package fr.call_of_rum.model.item;

public abstract class UseableItem extends Item {
	
	protected UseableItem(String namespace) {
		super(namespace);
	}

	public abstract void use();
	
}
