package fr.call_of_rum.controller;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.UseableItem;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Inventory;
import fr.call_of_rum.model.pirate.Pirate;

public class BuyController {
	
	private Market market;
	
	public BuyController(Market market) {
		this.market = market;
	}
	
	private void buyWeapon(Pirate pirate, Weapon weapon) {
		Weapon equippedWeapon = pirate.getEquippedWeapon();
		if (equippedWeapon == null) {
			pirate.equipWeapon(weapon);
			pirate.setCoins(pirate.getCoins() - weapon.getPrice());
		} else {
			Inventory<Item> inventory = pirate.getInventory();
			if (!inventory.isFull()) {
				inventory.add(weapon);
				pirate.setCoins(pirate.getCoins() - weapon.getPrice());
			}
		}
	}
	
	private void buyLiquid(Pirate pirate, Liquid liquid) {
		Inventory<Item> inventory = pirate.getInventory();
		if (!inventory.isFull()) {
			inventory.add(liquid);
			pirate.setCoins(pirate.getCoins() - liquid.getPrice());
		} else {
			pirate.drink(liquid);
		}
	}
	
	private void buyItem(Pirate pirate, UseableItem item) {
		Inventory<Item> inventory = pirate.getInventory();
		if (!inventory.isFull()) {
			inventory.add(item);
			pirate.setCoins(pirate.getCoins() - item.getPrice());
		}
	}

	public void buy(Pirate pirate, int itemIndex) {
		UseableItem boughtItem = market.getItem(itemIndex);
		
        int price = boughtItem.getPrice();
        int savings = pirate.getCoins();
        if (savings >= price) {
        	if (boughtItem instanceof Weapon boughtWeapon) {
        		buyWeapon(pirate, boughtWeapon);
        	} else if (boughtItem instanceof Liquid boughtLiquid) {
        		buyLiquid(pirate, boughtLiquid);
        	} else {
        		buyItem(pirate, boughtItem);
        	}
        }
	}
	
}
