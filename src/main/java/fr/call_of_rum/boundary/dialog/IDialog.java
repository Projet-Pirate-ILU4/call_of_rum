/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.call_of_rum.boundary.dialog;


import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;
import fr.call_of_rum.util.Player;

import java.util.List;

/**
 *
 * @author Solène
 */
public interface IDialog {
	
    CellType[] getCellsType();


    // donne le prix de l'item
    int getPrice(ItemType itemType);

    int getSizeInventaireAvailable(Player player);
    
    int checkfound(Player player);

           
    void endTurn();

    // renvoie un tableau de 4 item qui seront afficher dans le market
    ItemType[] getItemMarket();


    void buy(Player player, List<ItemType> itemTypesSelect);

    String getNameItem(ItemType itemType);

    String getDescribe(ItemType itemType);

	void useItem(int itemIndex, Player player);


	void throwItem(int itemIndex, Player player);


    String getDescribe2(int itemIndex);

    void print(String s);
    
    ItemType[] getDroppedItems(int cellIndex);
    
    int getNumberOfDroppedItems(int cellIndex);
    
    public void pickUpItem(int itemIndex);
}
