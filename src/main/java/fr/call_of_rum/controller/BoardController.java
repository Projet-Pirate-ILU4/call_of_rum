package fr.call_of_rum.controller;

import java.util.List;

import fr.call_of_rum.controller.accessible.IBoardController;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;

public class BoardController implements IBoardController {
	
	private PlayerController playerController;
	
	private Board board;
	
	public BoardController(Board board, PlayerController playerController) {
		this.playerController = playerController;
		this.board = board;
	}

	@Override
	public CellType getCellType(int cellNumber) {
		return board.getCell(cellNumber).getType();
	}

	@Override
	public ItemType[] getDroppedItems(int cellNumber) {
		Cell cell = board.getCell(cellNumber);
		List<Item> droppedItems = cell.getDroppedItems();
		int numberOfItems = droppedItems.size();
		ItemType[] droppedItemTypes = new ItemType[numberOfItems];
		for (int i = 0; i < numberOfItems; i++) {
			droppedItemTypes[i] = droppedItems.get(i).getType();
		}
		return droppedItemTypes;
	}

	@Override
	public int getNumberOfDroppedItems(int cellNumber) {
		Cell cell = board.getCell(cellNumber);
		List<Item> droppedItems = cell.getDroppedItems();
		return droppedItems.size();
	}
	
	public void pickUpItem(Pirate pirate, int itemIndex) {
		Cell cell = board.getCell(pirate);
		List<Item> droppedItems = cell.getDroppedItems();
		Item pickedItem = droppedItems.remove(itemIndex);
		playerController.takeItem(pirate, pickedItem);
	}

}
