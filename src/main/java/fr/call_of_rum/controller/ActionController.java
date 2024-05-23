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

	private boolean canMove = false;
	private Pirate pirate;
	
	public ActionController(MarketController marketController, MoveController moveController, BoardController boardController) {
		this.marketController = marketController;
		this.moveController = moveController;
		this.boardController = boardController;
	}
	
	public void setCurrentPirate(Pirate pirate) {
		this.canMove = true;
		this.pirate = pirate;
	}
	
	@Override
	public boolean buyItem(int itemIndex) {
		return marketController.buy(pirate, itemIndex);
	}

	@Override
	public boolean drink(int itemIndex) {
		Item item = pirate.getInventory().get(itemIndex);
		if (item instanceof Liquid liquid) {
			pirate.drink(liquid);
			return true;
		}
		return false;
	}

	@Override
	public boolean equipWeapon(int itemIndex) {
		Item item = pirate.getInventory().get(itemIndex);
		if (item instanceof Weapon weapon) {
			Weapon equippedWeapon = pirate.getEquippedWeapon();
			pirate.equipWeapon(weapon);
			if (equippedWeapon != null) {
				pirate.getInventory().add(equippedWeapon);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean pickUpItem(int itemIndex) {
		return boardController.pickUpItem(pirate, itemIndex);
	}

	@Override
	public boolean dropItem(int itemIndex) {
		Item item = pirate.getInventory().get(itemIndex);
		if (item == null) return false;
		item.drop();
		return true;
	}
	
	@Override
	public boolean move() {
		if (canMove) {
			moveController.movePirate(pirate);
			this.canMove = false;
		}
		return canMove;
	}

}
