package fr.call_of_rum.model.board.cells;

import java.util.ArrayList;
import java.util.List;

import fr.call_of_rum.model.item.Item;

public class Cell {
	
	private int num;
	private List<Item> droppedItems;
	
	public Cell(int num) {
		this.num = num;
		droppedItems = new ArrayList<>();
	}
	
	public int getNum() {
		return num;
	}
	
	public List<Item> getAllItems() {
		return droppedItems;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + num;
	}
	
}
