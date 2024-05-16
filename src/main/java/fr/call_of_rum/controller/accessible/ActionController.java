package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.util.Player;

public interface ActionController {
	
	void buyItem(Player player, int itemIndex);
	
	void drink(Player player, int itemIndex);
	
	void equipWeapon(Player player, int itemIndex);
	
	void dropItem(Player player, int itemIndex);
	
}
