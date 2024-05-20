package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public interface PlayerController {
	
	ItemType getEquippedWeapon();
	
	ItemType getItemType(int itemIndex);
	
	int getHealth(Player player);
	
	int getMaxHealth(Player player);
	
	float getIntoxicationLevel(Player player);
	
}
