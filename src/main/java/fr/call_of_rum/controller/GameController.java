package fr.call_of_rum.controller;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class GameController {
	
	private IBoundary boundary;
	
	private Board board;
	private int numberOfPlayers;
	private Pirate[] players = new Pirate[2];
	private int currentPlayer = 0;
	
	public GameController(IBoundary boundary, Board board, Pirate player1, Pirate player2) {
		this.boundary = boundary;
		this.board = board;
		this.numberOfPlayers = Player.values().length;
		players[0] = player1;
		players[1] = player2;
	}
	
	private Player getWinner() {
		if (players[0].getHealthPoints() == 0) return Player.BILL_JAMBE_DE_BOIS;
		if (players[1].getHealthPoints() == 0) return Player.JACK_LE_BORGNE;
		if (players[0].getCoins() > players[1].getCoins()) return Player.JACK_LE_BORGNE;
		if (players[1].getCoins() > players[0].getCoins()) return Player.BILL_JAMBE_DE_BOIS;
		return null;
	}
	
	private boolean isGameFinished() {
		return  players[0].getHealthPoints() == 0 ||
				players[1].getHealthPoints() == 0 ||
				board.getCell(players[0]).getNum() == board.getBoardSize() - 1 ||
				board.getCell(players[1]).getNum() == board.getBoardSize() - 1;
	}
	
	public void start() {
		while (!isGameFinished()) {
			boundary.giveTurn(Player.values()[currentPlayer]);
			currentPlayer = (currentPlayer + 1) % numberOfPlayers;
		}
		boundary.gameEnded(getWinner());
	}
	
}
