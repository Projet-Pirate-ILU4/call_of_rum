package fr.call_of_rum.model.board.cells;

public abstract class Trap extends Cell {
	
	public Trap(int num) {
		super(num);
	}

	public abstract void action();
	
}
