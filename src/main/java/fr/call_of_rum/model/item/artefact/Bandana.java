package fr.call_of_rum.model.item.artefact;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.ItemType;

public class Bandana extends Item {

	private static final ItemType ITEM_TYPE = ItemType.BANDANA;
	
	public Bandana() {
		super(ITEM_TYPE);
	}

}
