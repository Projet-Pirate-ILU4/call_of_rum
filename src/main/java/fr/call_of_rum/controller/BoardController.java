package fr.call_of_rum.controller;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.util.CellType;

public class BoardController implements IBoardController {
	
	private Board board;
	
	public BoardController(Board board) {
		this.board = board;
	}

	@Override
	public CellType getCellType(int cellNumber) {
		return board.getCell(cellNumber).getType();
		
	}

}
