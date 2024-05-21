package fr.call_of_rum.controller;

import java.util.Optional;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.CellType;

public class MoveController {
	
	private IBoundary boundary;
	
	private DiceController diceController;
	private PlayerController playerController;
	
	private Board board;
	private Pirate pirate1;
	private Pirate pirate2;
	
	public MoveController(IBoundary boundary, DiceController diceController, PlayerController playerController, Board board, Pirate pirate1, Pirate pirate2) {
		this.boundary = boundary;
		this.diceController = diceController;
		this.playerController = playerController;
		this.board = board;
		this.pirate1 = pirate1;
		this.pirate2 = pirate2;
	}
	
	private void triggerChestCell(Chest chest, Pirate pirate) {
		int chestCoins = chest.getCoins();
		chest.setOpened(true);
		pirate.setCoins(pirate.getCoins() + chestCoins);
		chest.setCoins(0);
		boolean tookItem = boundary.chestFound(chestCoins, chest.getItem().getType().toString().toLowerCase());
		if (tookItem) {
			playerController.takeItem(pirate, chest.getItem());
			chest.setItem(null);
		}
	}
	
	private void triggerOpenedChestCell(Chest chest) {
		Item chestItem = chest.getItem();
		Optional<String> itemNamespace = chestItem == null ? Optional.empty() : Optional.of(chestItem.getType().toString().toLowerCase());
		boundary.openedChestFound(chest.getCoins(), itemNamespace);
		
	}
	
	private void triggerBombCell(Pirate pirate) {
		pirate.setHealthPoints(pirate.getHealthPoints() - 2);
		boundary.stepOnBomb();
	}
	
	private void triggerShortcut(Pirate pirate) {
		Pirate otherPirate = pirate.equals(pirate1) ? pirate2 : pirate1;
		board.movePirateTo(pirate, otherPirate);
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
	
	public void movePirate(Pirate pirate) {
		int pirateLocation = board.getPirateLocation(pirate);
		int newLocation = pirateLocation + diceController.getDiceResult();
		board.movePirateTo(pirate, newLocation);
		this.triggerCell(board.getCell(newLocation), pirate);
	}
	
}
