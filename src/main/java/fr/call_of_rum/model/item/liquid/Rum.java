package fr.call_of_rum.model.item.liquid;

import fr.call_of_rum.util.ItemType;

public class Rum extends Liquid {
	
	private static final ItemType ITEM_TYPE = ItemType.RUM;
	
	private static final int RECOVERY = 2;
	private static final float INTOXICATION = 0.4f;

	public Rum() {
		super(ITEM_TYPE, RECOVERY, INTOXICATION);
	}

}
