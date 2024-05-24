/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.call_of_rum.boundary.dialog;


import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

/**
 *
 * @author Solène
 */
public interface IDialog {
	
	// ### ACTIONS ###
	boolean buy(int itemIndex);
	
	boolean drink(Player player, int itemIndex);
	
	boolean equip(Player player, int itemIndex);
	
	boolean dropItem(Player player, int itemIndex);
	
	boolean pickUpItem(int itemIndex);
	
	boolean move();
	
	// ### INFORMATIONS ###
	// # cells
	CellType[] getCellsType();
	
	ItemType[] getDroppedItems(int cellIndex);
	
	int getNumberOfDroppedItems(int cellIndex);
	
	// # market
	// get the items in the market
	ItemType[] getMarketItems();
	
	// get the price of an item in the market
	int getPrice(int itemIndex);
	
	int getNumberOfFreeSlots();
	
	// # player
	int checkfunds(Player player);
	
	ItemType[] getInventory(Player player);
	
	int getPlayerHealth(Player player);
	
	int getPlayerMaxHealth(Player player);
	
	ItemType getWeapon(Player player);
	
	float getIntoxication(Player player);
	
	// # dice
	int getDicesResult();
	
	// # items String resolution
	String getItemName(ItemType itemType);
	
	String getItemDescription(ItemType itemType);
	
	// ### SPECIAL REQUESTS ###
	boolean isLiquid(ItemType itemType);
	
	boolean isWeapon(ItemType itemType);
	
	void print(String s);
	
	void endTurn();

    Player getPlayer2();

	Player getPlayer1();

	Player getDuelWinner();
}
