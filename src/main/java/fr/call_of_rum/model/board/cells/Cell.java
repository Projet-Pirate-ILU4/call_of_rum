package fr.call_of_rum.model.board.cells;

import java.util.ArrayList;
import java.util.List;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.CellType;

public abstract class Cell {
	
	private int num;
	private List<Item> droppedItems;
	
	protected Cell(int num) {
		this.num = num;
		droppedItems = new ArrayList<>();
	}
	
	public abstract CellType getType();
	
	public int getNum() {
		return num;
	}
	
	public List<Item> getDroppedItems() {
		return droppedItems;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + num;
	}
	
}
