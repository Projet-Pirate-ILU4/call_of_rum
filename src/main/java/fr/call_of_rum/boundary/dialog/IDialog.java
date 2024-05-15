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
	
    CellType[] getCellsType();


    // donne le prix de l'item
    int getPrice(ItemType itemType);

    int getSizeInventaireAvailable(Player player);
    
    int checkfound(Player player);
    
    
           
    void endTurn();

    // renvoie un tableau de 4 item qui seront afficher dans le market
    ItemType[] getItemMarket();


    void buy(Player player,ItemType[] itemTypesSelect);


	boolean buy(ItemType item, Player player);
}
