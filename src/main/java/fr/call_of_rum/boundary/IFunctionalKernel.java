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
    
    boolean buyItem(int itemIndex);
	
    boolean drink(int itemIndex);
	
    boolean equipWeapon(int itemIndex);
	
    boolean pickUpItem(int itemIndex);
	
    boolean dropItem(int itemIndex);
	
    boolean move();
    
}
