package fr.call_of_rum.controller;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.controller.accessible.DiceControllerImpl;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class GameController {
	
	private IBoundary boundary;
	
	private DiceControllerImpl rollDiceController;
	
	private Board board;
	private int numberOfPlayers;
	private Pirate[] pirates = new Pirate[2];
	private int currentPlayer = 0;
	
	public GameController(IBoundary boundary, DiceControllerImpl rollDiceController, Board board, Pirate player1, Pirate player2) {
		this.boundary = boundary;
		this.rollDiceController = rollDiceController;
		this.board = board;
		this.numberOfPlayers = Player.values().length;
		pirates[0] = player1;
		pirates[1] = player2;
	}
	
	private Player getWinner() {
		if (pirates[0].getHealthPoints() == 0) return Player.BILL_JAMBE_DE_BOIS;
		if (pirates[1].getHealthPoints() == 0) return Player.JACK_LE_BORGNE;
		if (pirates[0].getCoins() > pirates[1].getCoins()) return Player.JACK_LE_BORGNE;
		if (pirates[1].getCoins() > pirates[0].getCoins()) return Player.BILL_JAMBE_DE_BOIS;
		return null;
	}
	
	private boolean isGameFinished() {
		return  pirates[0].getHealthPoints() == 0 ||
				pirates[1].getHealthPoints() == 0 ||
				board.getCell(pirates[0]).getNum() == board.getBoardSize() - 1 ||
				board.getCell(pirates[1]).getNum() == board.getBoardSize() - 1;
	}
	
	public void start() {
		while (!isGameFinished()) {
			rollDiceController.rollDices();
			boundary.giveTurn(Player.values()[currentPlayer]);
			System.out.println(Player.values()[currentPlayer] + " location is " + board.getCell(getPirate()).getNum() + " and size-1 is " + (board.getBoardSize() - 1));
			currentPlayer = (currentPlayer + 1) % numberOfPlayers;
		}
		boundary.gameEnded(getWinner());
	}
	
	/************************************
	*   Methods for other Controllers   *
	************************************/
	
	public Pirate getPirate() {
		return pirates[currentPlayer];
	}
	
	public Pirate getPirate(Player player) {
		if (player == null) return null;
		return pirates[player.ordinal()];
	}
	
}
