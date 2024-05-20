package fr.call_of_rum.controller.accessible;

import fr.call_of_rum.util.ItemType;

public interface MarketController {
	
	ItemType[] getItemForSale();
	
	int getPrice(int itemIndex);
	
}
