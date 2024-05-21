package fr.call_of_rum.boundary;

import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;

/**
 * This interface contains all functionalities that the kernel should provide.
 */
public interface IFunctionalKernel {

    CellType askCellType(int numCell);
    
    ItemType[] getDroppedItems(int numCell);
    
    int getNumberOfDroppedItems(int numCell);
    
    void buyItem(int itemIndex);
	
	void drink(int itemIndex);
	
	void equipWeapon(int itemIndex);
	
	void pickUpItem(int itemIndex);
	
	void dropItem(int itemIndex);
	
	void move();
    
}
