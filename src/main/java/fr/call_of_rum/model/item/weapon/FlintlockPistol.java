package fr.call_of_rum.model.item.weapon;

import fr.call_of_rum.util.ItemType;

public class FlintlockPistol extends Weapon {
	
	private static final ItemType ITEM_TYPE = ItemType.FLINTLOCK_PISTOL;
	
	private static final float FIGHT_BONUS = 0.4f;
	private static final int DAMAGES = 3;
	private static final float STEALING_POTENTIAL = 0.1f;
	
	public FlintlockPistol() {
		super(ITEM_TYPE, FIGHT_BONUS, DAMAGES, STEALING_POTENTIAL);
	}

}
