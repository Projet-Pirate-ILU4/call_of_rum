package fr.call_of_rum.boundary;

import java.util.Optional;

import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

/**
 * This interface contains all functionalities that a boundary should provide.
 */
public interface IBoundary {
	
	void giveTurn(Player player);
	
	void stepOnBomb();
	
	void tookShortcut();
	
	boolean chestFound(int coinAmount, ItemType itemNamespace);
	
	boolean openedChestFound(int coinAmount, Optional<ItemType> itemNamespace);
	
	void duel(Player winner);
	
	void gameEnded(Player winner);
	
}
