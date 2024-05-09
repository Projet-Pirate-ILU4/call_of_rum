package fr.call_of_rum.model.board.cells;

public class Trap extends Cell {
	
	private TrapType trapType;

	public Trap(int num, TrapType trapType) {
		super(num);
		this.trapType = trapType;
	}
	
	public TrapType getTrapType() {
		return trapType;
	}
	
}
