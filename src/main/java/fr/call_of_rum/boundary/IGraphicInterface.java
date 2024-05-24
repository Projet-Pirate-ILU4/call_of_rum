package fr.call_of_rum.boundary;

import java.util.Optional;

import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

public interface IGraphicInterface {
	
	void giveTurn(Player player);
	
	boolean chestFound(int coinAmount, ItemType itemType);
	
	boolean openedChestFound(int coinAmount, Optional<ItemType> optionalItemType);
	
	void showExplosion();
	
	void showShortcut();
	
	void showDuel(Player winner);
	
	void updateScores();
	
	void printMessage(String msg);
	
	void clearMessages();
	
	void close();
	
}
