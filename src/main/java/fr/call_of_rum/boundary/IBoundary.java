package fr.call_of_rum.boundary;

import java.util.Optional;

import fr.call_of_rum.util.Player;

/**
 * This interface contains all functionalities that a boundary should provide.
 */
public interface IBoundary {
	
	void giveTurn(Player player);
	
	void stepOnBomb();
	
	void tookShortcut();
	
	boolean chestFound(int coinAmount, String itemNamespace);
	
	boolean openedChestFound(int coinAmount, Optional<String> itemNamespace);
	
	void gameEnded(Player winner);
	
}
