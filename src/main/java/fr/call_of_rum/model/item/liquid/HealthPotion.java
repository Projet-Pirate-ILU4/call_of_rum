package fr.call_of_rum.model.item.liquid;

import fr.call_of_rum.util.ItemType;

public class HealthPotion extends Liquid {
	
	private static final ItemType ITEM_TYPE = ItemType.HEALTH_POTION;
	
	private static final int RECOVERY = 1;
	private static final float INTOXICATION = 0.0f;

	public HealthPotion() {
		super(ITEM_TYPE, RECOVERY, INTOXICATION);
	}
	
}
