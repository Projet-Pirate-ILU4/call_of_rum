package fr.call_of_rum.controller.game;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.pirate.Pirate;

public class GameController {
	
	private IBoundary boundary;
	
	private Board board;
	private Pirate player1;
	private Pirate player2;
	
	public GameController(IBoundary boundary, Board board, Pirate player1, Pirate player2) {
		this.boundary = boundary;
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	private int getWinner() {
		return 1;
	}
	
	private boolean isGameFinished() {
		return true;
	}
	
	public void start() {
		while (!isGameFinished()) {
			/* change player turn
			    -> tell x it's his turn
			    get the dices result
			    tell x that he can throw dices
			    wait for x (he can do whatever he wants but we are waiting the dices and move it's pawn)
			    move x in the model
			    fire cell actions (chests, traps, dropped items ...)
			    tell x about actions (like showing Item in chest)
			*/
		}
		boundary.gameEnded(getWinner());
	}
	
}
