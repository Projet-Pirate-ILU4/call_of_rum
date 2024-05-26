package fr.call_of_rum.model.item.weapon;

import fr.call_of_rum.util.ItemType;

public class Musket extends Weapon {
	
	private static final ItemType ITEM_TYPE = ItemType.MUSKET;
	
	private static final float FIGHT_BONUS = 0.3f;
	private static final int DAMAGES = 4;
	private static final float STEALING_POTENTIAL = 0.1f;
	
	public Musket() {
		super(ITEM_TYPE, FIGHT_BONUS, DAMAGES, STEALING_POTENTIAL);
	}
	
}
