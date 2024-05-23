package fr.call_of_rum.scenario.gui;

import fr.call_of_rum.boundary.FunctionalKernelAdapter;
import fr.call_of_rum.boundary.dialog.Dialog;
import fr.call_of_rum.controller.ActionController;
import fr.call_of_rum.controller.BoardController;
import fr.call_of_rum.controller.DiceController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MarketController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.PlayerController;
import fr.call_of_rum.scenario.Scenario;

public abstract class GUIScenario extends Scenario {
	
	private FunctionalKernelAdapter boundary;

	private ActionController actionController;
	private BoardController boardController;
	private DiceController diceController;
	private GameController gameController;
	private MarketController marketController;
	private MoveController moveController;
	private PlayerController playerController;
	
	@Override
	public void start() {
		if (boundary == null) boundary = new FunctionalKernelAdapter();
		
		player1.setBoard(board);
		player2.setBoard(board);
		
		if (diceController == null) diceController = new DiceController(super.rng);
		if (playerController == null) playerController = new PlayerController(player1, player2);
		if (boardController == null) boardController = new BoardController(board, playerController);
		if (marketController == null) marketController = new MarketController(market, playerController);
		if (moveController == null) moveController = new MoveController(rng, boundary, diceController, playerController, board, player1, player2);
		if (actionController == null) actionController = new ActionController(marketController, moveController, boardController);
		if (gameController == null) gameController = new GameController(boundary, actionController, diceController, board, player1, player2);

		boundary.setActionController(actionController);
		boundary.setBoardController(boardController);
		Dialog dialog = new Dialog(boundary);
		boundary.setGraphicInterface(dialog);
		
		dialog.initDialog();
		
		gameController.start();
	}

}
