package fr.call_of_rum.boundary.presentation;

import java.util.Optional;

import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public interface IPresentation {
	
	// ### INTERACTIONS ###
	void enableFirstPlayer();
	
	void enableSecondPlayer();
	
	// ### SHOW ###
	boolean chestFound(int coinAmount, ItemType itemType);
	
	boolean openedChestFound(int coinAmount, Optional<ItemType> optionalItemType);
	
	void showExplosion();
	
	void showShortcut();
	
	void showDuel(Player player);
	
	void printMessage(String message);
	
	// ### NOTIFICATIONS ###
	void updateScores();
	
	void clearMessages();
	
	void notifyDrop(ItemType itemType);
	
	void notifyPickUp(ItemType itemType);
        
        void notifyDicesThrown(boolean choice);
	
}
