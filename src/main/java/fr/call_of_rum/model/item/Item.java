package fr.call_of_rum.model.item;

import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ItemType;

public abstract class Item {
	
	protected Pirate owner;
	private ItemType itemType;
	
	protected Item(ItemType itemType) {
		this.itemType = itemType;
	}
	
	public Pirate getOwner() {
		return owner;
	}
	
	public void setOwner(Pirate newOwner) {
		this.owner = newOwner;
	}
	
	public ItemType getType() {
		return itemType;
	}
	
	public void drop() {
		owner.getBoard().getCell(owner).getDroppedItems().add(this);
		owner.getInventory().remove(this);
		owner = null;
	}
	
}
