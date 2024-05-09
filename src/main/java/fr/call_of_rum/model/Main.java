package fr.call_of_rum.model;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.artefacts.Clover;
import fr.call_of_rum.model.pirate.Pirate;

public class Main {
	
	public static void main(String[] args) {
		Pirate pirate = new Pirate("Bill Jambe De Bois", 0, 5);
		Clover clover = new Clover();
		Board board = BoardFactory.getDefaultBoard();
		
		pirate.setCoins(5);
		pirate.give(clover);
		System.out.println("board: " + board);
		System.out.println("cell of pirate: " + board.getCellOf(pirate));
		board.addPirate(pirate);
		System.out.println("cell of pirate: " + board.getCellOf(pirate));
		board.movePirate(pirate, 4);
		System.out.println("cell of pirate: " + board.getCellOf(pirate));
		System.out.println("pirate's Inventory: " + pirate.getInventory());
		pirate.getInventory().get(0).drop();
		System.out.println("pirate's Inventory: " + pirate.getInventory());
		System.out.println("END of execution");
	}
	
}
