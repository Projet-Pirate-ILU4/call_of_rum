package fr.call_of_rum.scenario;

import fr.call_of_rum.boundary.ConsoleBoundary;
import fr.call_of_rum.controller.BuyController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.TakeItemController;
import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.ActionControllerImpl;
import fr.call_of_rum.controller.accessible.BoardController;
import fr.call_of_rum.controller.accessible.BoardControllerImpl;
import fr.call_of_rum.controller.accessible.DiceControllerImpl;
import fr.call_of_rum.controller.accessible.PlayerController;
import fr.call_of_rum.controller.accessible.PlayerControllerImpl;

public abstract class TUIScenario extends Scenario {
	
	private ConsoleBoundary boundary = new ConsoleBoundary();

	private DiceControllerImpl diceController = new DiceControllerImpl();
	private GameController gameController;
	private TakeItemController takeItemController;
	private MoveController moveController;
	private BuyController buyController;
	private ActionController actionController;
	private PlayerController playerController;
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
		playerController = new PlayerControllerImpl(gameController);
		boardController = new BoardControllerImpl(gameController, board);

		boundary.setActionController(actionController);
		boundary.setBoardController(boardController);
		boundary.setDiceController(diceController);
		boundary.setPlayerController(playerController);
		
		gameController.start();
	}

}
