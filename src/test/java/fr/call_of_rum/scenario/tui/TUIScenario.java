package fr.call_of_rum.scenario.tui;

import fr.call_of_rum.boundary.ConsoleBoundary;
import fr.call_of_rum.controller.ActionController;
import fr.call_of_rum.controller.BoardController;
import fr.call_of_rum.controller.DiceController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MarketController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.PlayerController;
import fr.call_of_rum.scenario.Scenario;

public abstract class TUIScenario extends Scenario {
	
	private ConsoleBoundary boundary = new ConsoleBoundary();
	
	private ActionController actionController;
	private BoardController boardController;
	private DiceController diceController;
	private GameController gameController;
	private MarketController marketController;
	private MoveController moveController;
	private PlayerController playerController;
	
	@Override
	public void start() {
		player1.setBoard(board);
		player2.setBoard(board);
		
		diceController = new DiceController();
		playerController = new PlayerController(player1, player2);
		boardController = new BoardController(board, playerController);
		marketController = new MarketController(market, playerController);
		moveController = new MoveController(boundary, diceController, playerController, board, player1, player2);
		actionController = new ActionController(marketController, moveController, boardController);
		gameController = new GameController(boundary, actionController, diceController, board, player1, player2);

		boundary.setActionController(actionController);
		boundary.setBoardController(boardController);
		boundary.setDiceController(diceController);
		boundary.setPlayerController(playerController);
		
		gameController.start();
	}

}
