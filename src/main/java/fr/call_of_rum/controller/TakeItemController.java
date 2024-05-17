package fr.call_of_rum.controller;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Inventory;
import fr.call_of_rum.model.pirate.Pirate;

public class TakeItemController {
	
	public void takeItem(Pirate pirate, Item item) {
		Inventory<Item> inventory = pirate.getInventory();
		if (inventory.isFull()) {
			if (item instanceof Liquid liquid) {
				pirate.drink(liquid);
			} else if (item instanceof Weapon weapon && pirate.getEquippedWeapon() == null) {
				pirate.equipWeapon(weapon);
			}
		} else {
			inventory.add(item);
		}
	}
	
}
