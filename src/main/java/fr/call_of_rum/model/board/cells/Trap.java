package fr.call_of_rum.model.board.cells;

import fr.call_of_rum.util.CellType;

public class Trap extends Cell {
	
	private TrapType trapType;

	public Trap(int num, TrapType trapType) {
		super(num);
		this.trapType = trapType;
	}
	
	public TrapType getTrapType() {
		return trapType;
	}

	@Override
	public CellType getType() {
		return CellType.valueOf(trapType.toString());
	}
	
	@Override
	public String toString() {
		return trapType.toString() + super.getNum();
	}
}
