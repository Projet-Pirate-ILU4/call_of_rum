package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;

public interface IBoardController {
	
	CellType getCellType(int cellNumber);
	
	ItemType[] getDroppedItems(int cellNumber);
	
	int getNumberOfDroppedItems(int cellNumber);
	
}
