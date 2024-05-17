package fr.call_of_rum.controller;

import java.util.Optional;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.CellType;

public class TriggerCellController {
	
	private IBoundary boundary;
	
	private TakeItemController takeItemController;
	
	public TriggerCellController(IBoundary boudary, TakeItemController takeItemController) {
		this.boundary = boudary;
		this.takeItemController = takeItemController;
	}
	
	private void triggerChestCell(Chest chest, Pirate pirate) {
		int chestCoins = chest.getCoins();
		chest.setOpened(true);
		pirate.setCoins(pirate.getCoins() + chestCoins);
		chest.setCoins(0);
		boolean tookItem = boundary.chestFound(chestCoins, chest.getItem().getNamespace());
		if (tookItem) {
			takeItemController.takeItem(pirate, chest.getItem());
			chest.setItem(null);
		}
	}
	
	private void triggerOpenedChestCell(Chest chest) {
		Item chestItem = chest.getItem();
		Optional<String> itemNamespace = chestItem == null ? Optional.empty() : Optional.of(chestItem.getNamespace());
		boundary.openedChestFound(chest.getCoins(), itemNamespace);
		
	}
	
	private void triggerBombCell(Pirate pirate) {
		pirate.setHealthPoints(pirate.getHealthPoints() - 2);
		boundary.stepOnBomb();
	}
	
	private void triggerShortcut(Pirate pirate) {
		// TODO implements for the neareast pirate
		pirate.getBoard().movePirateTo(pirate, 9);
		boundary.tookShortcut();
	}
	
	private void triggerMerchant() {
		// TODO implements
	}
	
	public void triggerCell(Cell cell, Pirate pirate) {
		CellType cellType = cell.getType();
		switch (cellType) {
		case CHEST:
			triggerChestCell((Chest) cell, pirate);
			break;
		case OPENED_CHEST:
			triggerOpenedChestCell((Chest) cell);
			break;
		case BOMB:
			triggerBombCell(pirate);
			break;
		case SHORTCUT:
			triggerShortcut(pirate);
			break;
		case MERCHANT:
			triggerMerchant();
			break;
		default:
			break;
		}
	}
	
}
