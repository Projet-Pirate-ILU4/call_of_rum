package fr.call_of_rum.controller;

import java.util.List;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.inventory.Inventory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;

public class TakeItemController {
	
	private Board board;
	
	public TakeItemController(Board board) {
		this.board = board;
	}
	
	public boolean pickUpItem(Pirate pirate, int itemIndex) {
		Cell pirateCell = board.getCell(pirate);
		List<Item> droppedItems = pirateCell.getDroppedItems();
		Item item = droppedItems.get(itemIndex);
		
		if (takeItem(pirate, item)) {
			droppedItems.remove(itemIndex);
			return true;
		}
		return false;
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
	
}
