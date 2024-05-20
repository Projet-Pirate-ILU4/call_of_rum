package fr.call_of_rum.controller.accessible;

import java.util.List;

import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public class BoardControllerImpl implements BoardController {
	
	private GameController gameController;
	
	private Board board;
	
	public BoardControllerImpl(GameController gameController, Board board) {
		this.gameController = gameController;
		this.board = board;
	}

	@Override
	public CellType getCellType(int cellNumber) {
		return board.getCell(cellNumber).getType();
	}

	@Override
	public ItemType[] getDroppedItems() {
		Pirate pirate = gameController.getPirate();
		Cell pirateCell = board.getCell(pirate);
		List<Item> droppedItems = pirateCell.getDroppedItems();
		int numberOfItems = droppedItems.size();
		ItemType[] droppedItemTypes = new ItemType[numberOfItems];
		for (int i = 0; i < numberOfItems; i++) {
			droppedItemTypes[i] = droppedItems.get(i).getType();
		}
		return droppedItemTypes;
	}

	@Override
	public int getPirateCellNumber(Player player) {
		Pirate pirate = gameController.getPirate(player);
		return board.getPirateLocation(pirate);
	}

}
