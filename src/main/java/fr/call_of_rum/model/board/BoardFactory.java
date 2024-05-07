package fr.call_of_rum.model.board;

import fr.call_of_rum.model.board.cells.Cell;

public class BoardFactory {
	
	private int numberOfCells = 30;
	
	public static BoardFactory getFactory() {
		return new BoardFactory();
	}
	
	public static Board getDefaultBoard() {
		return new BoardFactory().build();
	}
	
	public Board build() {
		Cell[] cells = new Cell[numberOfCells];
		for (int i = 0; i < numberOfCells; i++) {
			cells[i] = new Cell(i);
			// TODO implements random generation
		}
		int merchant = 16;
		// TODO randomly generate merchant index
		return new Board(cells, numberOfCells, merchant);
	}
	
}
