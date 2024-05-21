package fr.call_of_rum.scenario.gui;

import fr.call_of_rum.boundary.FunctionalKernelAdapter;
import fr.call_of_rum.boundary.dialog.Dialog;
import fr.call_of_rum.controller.BuyController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.TakeItemController;
import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.ActionControllerImpl;
import fr.call_of_rum.controller.accessible.BoardController;
import fr.call_of_rum.controller.accessible.BoardControllerImpl;
import fr.call_of_rum.controller.accessible.DiceControllerImpl;
import fr.call_of_rum.scenario.Scenario;

public abstract class GUIScenario extends Scenario {
	
	private FunctionalKernelAdapter boundary = new FunctionalKernelAdapter();

	private DiceControllerImpl diceController = new DiceControllerImpl();
	private GameController gameController;
	private TakeItemController takeItemController;
	private MoveController moveController;
	private BuyController buyController;
	private ActionController actionController;
	private BoardController boardController;
	
	@Override
	public void start() {
		board.addPirate(player1);
		board.addPirate(player2);
		
		gameController = new GameController(boundary, diceController, board, player1, player2);
		takeItemController = new TakeItemController(board);
		moveController = new MoveController(boundary, diceController, takeItemController, board);
		buyController = new BuyController(takeItemController, market);
		actionController = new ActionControllerImpl(gameController, buyController, takeItemController, moveController);
		boardController = new BoardControllerImpl(gameController, board);

		boundary.setActionController(actionController);
		boundary.setBoardController(boardController);
		Dialog dialog = new Dialog(boundary);
		boundary.setGraphicInterface(dialog);
		
		dialog.initDialog();
		
		gameController.start();
	}

}
