package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.WeaponType;

public interface PlayerItemController {
	
	WeaponType getEquippedWeapon();
	
	ItemType getItemType(int itemIndex);
	
}
