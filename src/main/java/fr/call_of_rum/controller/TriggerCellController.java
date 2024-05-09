package fr.call_of_rum.controller;

import java.util.Optional;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.ChestCell;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.CellType;

public class TriggerCellController {
	
	private IBoundary boundary;
	
	private GameController gameController;
	
	public TriggerCellController(IBoundary boudary, GameController gameController) {
		this.boundary = boudary;
		this.gameController = gameController;
	}
	
	private void triggerChestCell(ChestCell chest) {
		boundary.chestFound(chest.getCoins(), chest.getItem().getNamespace());
		chest.setOpened(true);
	}
	
	private void triggerOpenedChestCell(ChestCell chest) {
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
			triggerChestCell((ChestCell) cell);
			break;
		case OPENED_CHEST:
			triggerOpenedChestCell((ChestCell) cell);
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
