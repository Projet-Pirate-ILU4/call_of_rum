package fr.call_of_rum.boundary;

import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

/**
 * This interface contains all functionalities that the kernel should provide.
 */
public interface IFunctionalKernel {
    
    boolean buyItem(int itemIndex);
	
    boolean drink(int itemIndex);
	
    boolean equipWeapon(int itemIndex);
	
    boolean pickUpItem(int itemIndex);
	
    boolean dropItem(int itemIndex);
	
    boolean move();

    CellType askCellType(int numCell);
    
    ItemType[] getDroppedItems(int numCell);
    
    int getNumberOfDroppedItems(int numCell);
    
    ItemType[] getItemsForSale();
	
	int getPrice(int itemIndex);
	
	int getScore(Player player);
	
	ItemType[] getInventory(Player player);
	
	int getHealth(Player player);
	
	int getMaxHealth(Player player);
	
	ItemType getWeapon(Player player);
	
	float getIntoxication(Player player);
	
	int getDicesResult();
    
}
