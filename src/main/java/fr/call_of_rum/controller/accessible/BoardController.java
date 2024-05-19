package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public interface BoardController {
	
	CellType getCellType(int cellNumber);
	
	ItemType[] getDroppedItems();
	
	int getPirateCellNumber(Player player);
	
}
