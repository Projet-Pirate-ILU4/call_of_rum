package fr.call_of_rum.model.board;

import java.util.HashMap;
import java.util.Map;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.pirate.Pirate;

public class Board {
	
	private Cell[] cells;
	private int boardSize;
	private int merchant;
	
	private Map<Pirate, Integer> pirateLocations = new HashMap<>();
	
	Board(Cell[] cells, int boardSize, int merchantIndex) {
		this.cells = cells;
		this.boardSize = boardSize;
		this.merchant = merchantIndex;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public void addPirate(Pirate pirate) {
		pirate.setBoard(this);
		pirateLocations.put(pirate, 0);
	}
	
	private int getPirateLocation(Pirate pirate) {
		if (!pirateLocations.containsKey(pirate))
			throw new PirateNotOnBoardException(pirate);
		return pirateLocations.get(pirate);
	}
	
	public Cell getCellOf(Pirate pirate) {
		int pirateLocation = getPirateLocation(pirate);
		return cells[pirateLocation];
	}
	
	public void movePirate(Pirate pirate, int amount) {
		int newLocation = pirateLocations.get(pirate) + amount % boardSize;
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
		for (i = 0; i < boardSize-1; i++) {
			if (i == merchant) str.append('M');
			str.append(cells[i]);
			str.append("|");
		}
		str.append(cells[i]);
		str.append("]");
		return str.toString();
	}
	
}
