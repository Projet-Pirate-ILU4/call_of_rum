package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Inventory;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class PlayerControllerImpl implements PlayerController {
	
	private GameController gameController;
	
	public PlayerControllerImpl(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public ItemType getEquippedWeapon() {
		Pirate pirate = gameController.getPirate();
		Weapon weapon = pirate.getEquippedWeapon();
		if (weapon == null) return null;
		return weapon.getType();
	}

	@Override
	public ItemType getItemType(int itemIndex) {
		Pirate pirate = gameController.getPirate();
		Inventory<Item> inventory = pirate.getInventory();
		Item item = inventory.get(itemIndex);
		if (item == null) return null;
		return item.getType();
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

}
