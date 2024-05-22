package fr.call_of_rum.controller;

import fr.call_of_rum.controller.accessible.IPlayerController;
import fr.call_of_rum.model.inventory.Inventory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class PlayerController implements IPlayerController {
	
	private Pirate pirate1;
	private Pirate pirate2;
	
	public PlayerController(Pirate pirate1, Pirate pirate2) {
		this.pirate1 = pirate1;
		this.pirate2 = pirate2;
	}
	
	private Pirate getPirate(Player player) {
		return pirate1.getPlayer() == player ? pirate1 : pirate2;
	}

	@Override
	public int getHealth(Player player) {
		Pirate pirate = getPirate(player);
		return pirate.getHealthPoints();
	}

	@Override
	public int getMaxHealth(Player player) {
		Pirate pirate = getPirate(player);
		return pirate.getMaxHealth();
	}

	@Override
	public float getIntoxicationLevel(Player player) {
		Pirate pirate = getPirate(player);
		return pirate.getIntoxicationGauge().getLevel();
	}

	@Override
	public int getCoins(Player player) {
		Pirate pirate = getPirate(player);
		return pirate.getCoins();
	}

	@Override
	public ItemType[] getInventoryItems(Player player) {
		Pirate pirate = getPirate(player);
		Inventory<Item> inventory = pirate.getInventory();
		ItemType[] itemTypes = new ItemType[3];
		for (int i = 0; i<3; i++) {
			Item item = inventory.get(i);
			itemTypes[i] = item == null ? null : item.getType();
		}
		return itemTypes;
	}

	@Override
	public ItemType getEquippedWeapon(Player player) {
		Pirate pirate = getPirate(player);
		Weapon weapon = pirate.getEquippedWeapon();
		return weapon == null ? null : weapon.getType();
	}
	
	public boolean takeItem(Pirate pirate, Item item) {
		Inventory<Item> inventory = pirate.getInventory();
		
		if (item instanceof Weapon weapon) {
			if (pirate.getEquippedWeapon() == null) {
				pirate.equipWeapon(weapon);
				weapon.setOwner(pirate);
				return true;
			}
			if (!inventory.isFull()) {
				inventory.add(weapon);
				weapon.setOwner(pirate);
				return true;
			}
		} else if (inventory.isFull()) {
			if (item instanceof Liquid liquid) {
				pirate.drink(liquid);
				return true;
			}
		} else {
			inventory.add(item);
			item.setOwner(pirate);
			return true;
		}
		return false;
	}

	@Override
	public int getLocation(Player player) {
		Pirate pirate = getPirate(player);
		return pirate.getLocation();
	}

}
