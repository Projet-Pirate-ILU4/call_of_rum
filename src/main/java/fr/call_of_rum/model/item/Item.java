package fr.call_of_rum.model.item;

import fr.call_of_rum.model.player.Pirate;

public abstract class Item {
	
	protected Pirate owner;
	
	public Pirate getOwner() {
		return owner;
	}
	
	public void setOwner(Pirate newOwner) {
		this.owner = newOwner;
	}
	
	public abstract String getName();
	
	public abstract String getDescription();
	
	public void drop() {
		owner.getBoard().getCellOf(owner).getAllItems().add(this);
		owner.getInventory().removeItem(this);
		owner = null;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
