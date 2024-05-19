package fr.call_of_rum.scenario;

import java.util.List;

import fr.call_of_rum.boundary.FunctionalKernelAdapter;
import fr.call_of_rum.boundary.dialog.Dialog;
import fr.call_of_rum.controller.BuyController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.TakeItemController;
import fr.call_of_rum.controller.TriggerCellController;
import fr.call_of_rum.controller.accessible.ActionController;
import fr.call_of_rum.controller.accessible.ActionControllerImpl;
import fr.call_of_rum.controller.accessible.BoardController;
import fr.call_of_rum.controller.accessible.BoardControllerImpl;
import fr.call_of_rum.controller.accessible.DiceControllerImpl;
import fr.call_of_rum.controller.accessible.PlayerController;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;

public abstract class GUIScenario {
	
	protected Dialog dialog;
	protected FunctionalKernelAdapter boundary;

	protected DiceControllerImpl diceController;
	protected GameController gameController;
	protected TakeItemController takeItemController;
	protected TriggerCellController triggerCellController;
	protected MoveController moveController;
	protected BuyController buyController;
	protected ActionController actionController;
	protected PlayerController playerController;
	protected BoardController boardController;
	
	protected ItemRegistry itemRegistry;
	protected Board board;
	protected Market market;
	protected Pirate pirate1;
	protected Pirate pirate2;

	protected GUIScenario() {
		// boundary initialization
    	boundary = new FunctionalKernelAdapter();
    	
    	// model initialization
    	itemRegistry = new ItemRegistry();
    	market = new Market(List.of());
    	pirate1 = new Pirate("Jack Le Borgne", 0, 10);
    	pirate2 = new Pirate("Bill Jambe De Bois", 0, 10);
    	
    	// controller initialization
    	diceController = new DiceControllerImpl();
    	takeItemController = new TakeItemController();
    	triggerCellController = new TriggerCellController(boundary, takeItemController);
    	buyController = new BuyController(takeItemController, market);
    	
    	// wiring IBoundary and IFunctionalKernel
    	boundary.setActionController(actionController);
	}
	
	protected void start() {
		if (board == null) {
			board = BoardFactory.getDefaultBoard(itemRegistry);
		}
    	board.addPirate(pirate1);
    	board.addPirate(pirate2);

    	gameController = new GameController(boundary, diceController, board, pirate1, pirate2);
    	moveController = new MoveController(diceController, triggerCellController, board);
    	actionController = new ActionControllerImpl(gameController, buyController, moveController);
    	boardController = new BoardControllerImpl(gameController, board);
    	
    	boundary.setBoardController(boardController);
    	
    	dialog = new Dialog(boundary);
    	boundary.setGraphicInterface(dialog);
    	dialog.initDialog();
    	
    	gameController.start();
	}

}
