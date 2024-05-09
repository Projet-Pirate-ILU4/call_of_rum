package fr.call_of_rum.controller;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.pirate.Pirate;

public class GameController {
	
	private IBoundary boundary;
	
	private Board board;
	private Pirate[] players;
	private int currentPlayer = 0;
	
	public GameController(IBoundary boundary, Board board, Pirate player1, Pirate player2) {
		this.boundary = boundary;
		this.board = board;
		this.players = new Pirate[2];
		this.players[0] = player1;
		this.players[1] = player2;
	}
	
	private int getWinner() {
		if (players[0].getHealthPoints() == 0) return 2;
		if (players[1].getHealthPoints() == 0) return 1;
		if (players[0].getCoins() > players[1].getCoins()) return 1;
		if (players[1].getCoins() > players[0].getCoins()) return 2;
		return 0;
	}
	
	private boolean isGameFinished() {
		return  players[0].getHealthPoints() == 0 ||
				players[1].getHealthPoints() == 0 ||
				board.getCellOf(players[0]).getNum() == board.getBoardSize() - 1 ||
				board.getCellOf(players[1]).getNum() == board.getBoardSize() - 1;
	}
	
	public void start() {
		while (!isGameFinished()) {
			boundary.giveTurn(currentPlayer+1);
			currentPlayer = (currentPlayer + 1) % 2;
		}
		boundary.gameEnded(getWinner());
	}
	
}
