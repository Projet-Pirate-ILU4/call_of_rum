package fr.call_of_rum.boundary;

import java.util.Optional;

import fr.call_of_rum.util.Player;

public interface IGraphicInterface {
	
	void giveTurn(Player player);
	
	void showChest(int coinAmount, String itemNamespace);
	
	void showOpenedChest(int coinAmount, Optional<String> itemNamespace);
	
	void showExplosion();
	
	void showShortcut();
	
	void printMessage(String msg);
	
	void clearMessages();
	
	void close();
	
}
