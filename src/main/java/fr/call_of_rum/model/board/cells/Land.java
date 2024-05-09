package fr.call_of_rum.model.board.cells;

import fr.call_of_rum.util.CellType;

public class Land extends Cell {

	public Land(int num) {
		super(num);
	}

	@Override
	public CellType getType() {
		return CellType.NORMAL;
	}

}
