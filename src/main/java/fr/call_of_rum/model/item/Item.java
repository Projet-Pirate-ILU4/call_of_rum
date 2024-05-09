package fr.call_of_rum.model.item;

import fr.call_of_rum.model.pirate.Pirate;

public abstract class Item {
	
	protected Pirate owner;
	private String namespace;
	
	protected Item(String namespace) {
		this.namespace = namespace;
	}
	
	public Pirate getOwner() {
		return owner;
	}
	
	public void setOwner(Pirate newOwner) {
		this.owner = newOwner;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	public void drop() {
		owner.getBoard().getCell(owner).getAllItems().add(this);
		owner.getInventory().removeItem(this);
		owner = null;
	}
	
	@Override
	public String toString() {
		return namespace;
	}
	
}
