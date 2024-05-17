package fr.call_of_rum.model.board;

import java.util.HashMap;
import java.util.Map;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ShortcutMethod;

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
	
	public Cell getCell(int cellNumber) {
		return cells[cellNumber % boardSize];
	}
	
	@ShortcutMethod
	public Cell getCell(Pirate pirate) {
		return getCell(getPirateLocation(pirate));
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public int getMerchantCellNumber() {
		return merchant;
	}
	
	public int getPirateLocation(Pirate pirate) {
		return pirateLocations.get(pirate);
	}
	
	public void addPirate(Pirate pirate) {
		pirate.setBoard(this);
		pirateLocations.put(pirate, 0);
	}
	
	public void movePirateTo(Pirate pirate, int cellNumber) {
		pirateLocations.replace(pirate, cellNumber % boardSize);
	}
	
	@ShortcutMethod
	public void movePirateTo(Pirate pirate, Pirate otherPirate) {
		pirateLocations.replace(pirate, getPirateLocation(otherPirate));
	}
	
	@ShortcutMethod
	public void movePirateToMerchant(Pirate pirate) {
		if (!canMoveToMerchant(getPirateLocation(pirate))) return;
		pirateLocations.replace(pirate, merchant);
	}

	public boolean canMoveToMerchant(int cellNumber) {
		return 7 <= cellNumber && cellNumber <= 26;
	}
	
	@ShortcutMethod
	public boolean canMoveToMerchant(Pirate pirate) {
		return canMoveToMerchant(getPirateLocation(pirate));
	}
	
	@ShortcutMethod
	public boolean isPirateOnMerchant(Pirate pirate) {
		return getPirateLocation(pirate) == merchant;
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
