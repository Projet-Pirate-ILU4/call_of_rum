package fr.call_of_rum.controller;

import fr.call_of_rum.controller.accessible.IActionController;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;

public class ActionController implements IActionController {
	
	private MarketController marketController;
	private MoveController moveController;
	private BoardController boardController;
	
	private Pirate pirate;
	
	public ActionController(MarketController marketController, MoveController moveController, BoardController boardController) {
		this.marketController = marketController;
		this.moveController = moveController;
		this.boardController = boardController;
	}
	
	public void setCurrentPirate(Pirate pirate) {
		this.pirate = pirate;
	}
	
	@Override
	public void buyItem(int itemIndex) {
		marketController.buy(pirate, itemIndex);
	}

	@Override
	public void drink(int itemIndex) {
		Item item = pirate.getInventory().get(itemIndex);
		if (item instanceof Liquid liquid) {
			pirate.drink(liquid);
		}
	}

	@Override
	public void equipWeapon(int itemIndex) {
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
	public void pickUpItem(int itemIndex) {
		boardController.pickUpItem(pirate, itemIndex);
	}

	@Override
	public void dropItem(int itemIndex) {
		Item item = pirate.getInventory().get(itemIndex);
		item.drop();
	}

	@Override
	public void move() {
		moveController.movePirate(pirate);
	}

}
