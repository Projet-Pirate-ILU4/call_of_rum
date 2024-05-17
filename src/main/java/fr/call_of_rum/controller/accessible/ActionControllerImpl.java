package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.controller.BuyController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;

public class ActionControllerImpl implements ActionController {
	
	private GameController gameController;
	private BuyController buyController;
	private MoveController moveController;
	
	public ActionControllerImpl(GameController gameController, BuyController buyController, MoveController moveController) {
		this.gameController = gameController;
		this.buyController = buyController;
		this.moveController = moveController;
	}
	
	@Override
	public void buyItem(int itemIndex) {
		Pirate pirate = gameController.getPirate();
		buyController.buy(pirate, itemIndex);
	}

	@Override
	public void drink(int itemIndex) {
		Pirate pirate = gameController.getPirate();
		Item item = pirate.getInventory().get(itemIndex);
		if (item instanceof Liquid liquid) {
			pirate.drink(liquid);
		}
	}

	@Override
	public void equipWeapon(int itemIndex) {
		Pirate pirate = gameController.getPirate();
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
	public void dropItem(int itemIndex) {
		Pirate pirate = gameController.getPirate();
		Item item = pirate.getInventory().get(itemIndex);
		item.drop();
	}

	@Override
	public void move() {
		Pirate pirate = gameController.getPirate();
		moveController.movePirate(pirate);
	}

}
