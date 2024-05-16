package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.UseableItem;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Inventory;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class ActionControllerImpl implements ActionController {
	
	private Market market;
	private Pirate[] pirates = new Pirate[2];
	
	public ActionControllerImpl(Market market, Pirate pirate1, Pirate pirate2) {
		pirates[0] = pirate1;
		pirates[1] = pirate2;
	}
	
	private Pirate getPirate(Player player) {
		return pirates[player.ordinal()];
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

	@Override
	public void buyItem(Player player, int itemIndex) {
		Pirate pirate = getPirate(player);
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

	@Override
	public void drink(Player player, int itemIndex) {
		Pirate pirate = getPirate(player);
		Item item = pirate.getInventory().get(itemIndex);
		if (item instanceof Liquid liquid) {
			pirate.drink(liquid);
		}
	}

	@Override
	public void equipWeapon(Player player, int itemIndex) {
		Pirate pirate = getPirate(player);
		Item item = pirate.getInventory().get(itemIndex);
		if (item instanceof Weapon weapon) {
			Weapon equippedWeapon = pirate.getEquippedWeapon();
			pirate.equipWeapon(weapon);
			if (equippedWeapon != null) {
				pirate.getInventory().add(equippedWeapon);
			}
		}
	}

	@Override
	public void dropItem(Player player, int itemIndex) {
		Pirate pirate = getPirate(player);
		Item item = pirate.getInventory().get(itemIndex);
		item.drop();
	}

}
