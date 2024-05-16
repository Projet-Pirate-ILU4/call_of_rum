package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.util.CellType;

public class BoardControllerImpl implements BoardController {
	
	private Board board;
	
	public BoardControllerImpl(Board board) {
		this.board = board;
	}

	@Override
	public CellType getCellType(int cellNumber) {
		return board.getCell(cellNumber).getType();
		
	}

}
