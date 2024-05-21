package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.model.inventory.Inventory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class PlayerControllerImpl implements PlayerController {
	
	private GameController gameController;
	
	public PlayerControllerImpl(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public int getHealth(Player player) {
		Pirate pirate = gameController.getPirate(player);
		return pirate.getHealthPoints();
	}

	@Override
	public int getMaxHealth(Player player) {
		Pirate pirate = gameController.getPirate(player);
		return pirate.getMaxHealth();
	}

	@Override
	public float getIntoxicationLevel(Player player) {
		Pirate pirate = gameController.getPirate(player);
		return pirate.getIntoxicationGauge().getLevel();
	}

	@Override
	public int getCoins(Player player) {
		Pirate pirate = gameController.getPirate(player);
		return pirate.getCoins();
	}

	@Override
	public ItemType[] getInventoryItems(Player player) {
		Pirate pirate = gameController.getPirate(player);
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
		Pirate pirate = gameController.getPirate(player);
		Weapon weapon = pirate.getEquippedWeapon();
		return weapon == null ? null : weapon.getType();
	}

}
