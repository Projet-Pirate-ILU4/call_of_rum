package fr.call_of_rum;

import fr.call_of_rum.boundary.ConsoleBoundary;
import fr.call_of_rum.controller.game.GameController;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.player.Pirate;

public class Main {
   
    public String getGreeting() {
         return "Hello World, this is Main!";
    }

    public static void main(String[] args) {
    	// boundary initialization
    	ConsoleBoundary boundary = new ConsoleBoundary();
    	
    	// model initialization
    	Board board = BoardFactory.getDefaultBoard();
    	Pirate pirate1 = new Pirate(0, 10);
    	Pirate pirate2 = new Pirate(0, 10);
    	board.addPirate(pirate1);
    	board.addPirate(pirate2);
    	
    	// controller initialization
    	GameController gameController = new GameController(boundary, board, pirate1, pirate2);
    	
    	// wiring IBoundary and IFunctionalKernel
    	
    	// launch
    	gameController.start();
    }

}