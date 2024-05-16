package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class ActionControllerImpl implements ActionController {
	
	private Pirate[] pirates = new Pirate[2];
	
	public ActionControllerImpl(Pirate pirate1, Pirate pirate2) {
		pirates[0] = pirate1;
		pirates[1] = pirate2;
	}
	
	private Pirate getPirate(Player player) {
		return pirates[player.ordinal()];
	}

	@Override
	public void buyItem(Player player, int itemIndex) {
		// TODO implements
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
