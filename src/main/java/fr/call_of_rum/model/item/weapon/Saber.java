package fr.call_of_rum.model.item.weapon;

import fr.call_of_rum.util.ItemType;

public class Saber extends Weapon {
	
	private static final ItemType ITEM_TYPE = ItemType.SABER;
	
	private static final float FIGHT_BONUS = 0.2f;
	private static final int DAMAGES = 4;
	private static final float STEALING_POTENTIAL = 0.6f;
	
	public Saber() {
		super(ITEM_TYPE, FIGHT_BONUS, DAMAGES, STEALING_POTENTIAL);
	}

}
