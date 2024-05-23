package fr.call_of_rum.model.board;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.ShortcutMethod;

public class Board {

	private Cell[] cells;
	private int boardSize;
	private int merchant;
	
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
		return getCell(pirate.getLocation());
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public int getMerchantCellNumber() {
		return merchant;
	}
	
	public void movePirateTo(Pirate pirate, int cellNumber) {
		pirate.setLocation(cellNumber % boardSize);
	}
	
	@ShortcutMethod
	public void movePirateTo(Pirate pirate, Pirate otherPirate) {
		this.movePirateTo(pirate, otherPirate.getLocation());
	}
	
	@ShortcutMethod
	public void movePirateToMerchant(Pirate pirate) {
		if (!canMoveToMerchant(pirate.getLocation())) return;
		pirate.setLocation(merchant);
	}

	public boolean canMoveToMerchant(int cellNumber) {
		return 7 <= cellNumber && cellNumber <= 26;
	}
	
	@ShortcutMethod
	public boolean canMoveToMerchant(Pirate pirate) {
		return canMoveToMerchant(pirate.getLocation());
	}
	
	@ShortcutMethod
	public boolean isPirateOnMerchant(Pirate pirate) {
		return pirate.getLocation() == merchant;
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
