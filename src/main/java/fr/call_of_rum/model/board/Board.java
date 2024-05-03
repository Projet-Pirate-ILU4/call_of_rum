package fr.call_of_rum.model.board;

import java.util.HashMap;
import java.util.Map;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.player.Pirate;

public class Board {
	
	private static final int BOARD_SIZE = 30;
	
	private int merchant;
	private Cell[] cells;
	private Map<Pirate, Integer> pirateLocations = new HashMap<>();
	
	Board() {
		cells = new Cell[BOARD_SIZE];
		// TODO init cells
		for (int i = 0; i < BOARD_SIZE; i++)
			cells[i] = new Cell(i);
		// TODO randomly set merchant index
		merchant = 16;
	}
	
	public void addPirate(Pirate pirate) {
		pirate.setBoard(this);
		pirateLocations.put(pirate, 0);
	}
	
	public Cell getCellOf(Pirate pirate) {
		if (!pirateLocations.containsKey(pirate)) return null;
		int pirateLocation = pirateLocations.get(pirate);
		return cells[pirateLocation];
	}
	
	public void movePirate(Pirate pirate, int amount) {
		int newLocation = pirateLocations.get(pirate) + amount % BOARD_SIZE;
		pirateLocations.replace(pirate, newLocation);
	}
	
	private boolean canMoveToMerchant(int cellIndex) {
		return 7 <= cellIndex && cellIndex <= 26;
	}
	
	public void moveToMerchant(Pirate pirate) {
		int pirateLocation = pirateLocations.get(pirate);
		if (!canMoveToMerchant(pirateLocation)) return;
		pirateLocations.replace(pirate, merchant);
	}
	
	public Cell getMerchantcell() {
		return cells[merchant];
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		int i;
		for (i = 0; i < BOARD_SIZE-1; i++) {
			if (i == merchant) str.append('M');
			str.append(cells[i]);
			str.append("|");
		}
		str.append(cells[i]);
		str.append("]");
		return str.toString();
	}
	
}
