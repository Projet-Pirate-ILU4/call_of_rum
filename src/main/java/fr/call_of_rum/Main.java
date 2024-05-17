package fr.call_of_rum;

import java.util.List;

import fr.call_of_rum.boundary.ConsoleBoundary;
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
import fr.call_of_rum.controller.accessible.PlayerControllerImpl;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.liquid.Rum;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;

public class Main {
   
    public String getGreeting() {
         return "Hello World, this is Main!";
    }
    
    public static void main(String[] args) {
    	/*// boundary initialization
    	FunctionalKernelAdapter boundary = new FunctionalKernelAdapter();
    	
    	// model initialization
    	Board board = BoardFactory.getDefaultBoard(new ItemRegistry());
    	Market market = new Market(List.of());
    	Pirate pirate1 = new Pirate("Jack Le Borgne", 0, 10);
    	Pirate pirate2 = new Pirate("Bill Jambe De Bois", 0, 10);
    	board.addPirate(pirate1);
    	board.addPirate(pirate2);
    	
    	// controller initialization
    	DiceController diceController = new DiceController();
    	GameController gameController = new GameController(boundary, diceController, board, pirate1, pirate2);
    	BoardController boardController = new BoardControllerImpl(board);
    	TriggerCellController triggerCellController = new TriggerCellController(boundary);
    	MoveController moveController = new MoveController(diceController, triggerCellController, board);
    	BuyController buyController = new BuyController(market);
    	ActionController actionController = new ActionControllerImpl(gameController, buyController, moveController);
    	
    	// wiring IBoundary and IFunctionalKernel
    	boundary.setBoardController(boardController);
    	boundary.setActionController(actionController);
    	Dialog dialog = new Dialog(boundary);
    	boundary.setGraphicInterface(dialog);
    	dialog.initDialog();
    	
    	// launch
    	gameController.start();*/
    	
    	// boundary initialization
    	ConsoleBoundary boundary = new ConsoleBoundary();
    	
    	// model initialization
    	Board board = BoardFactory.getDefaultBoard(new ItemRegistry().registerItem(Rum.class));
    	Market market = new Market(List.of());
    	Pirate pirate1 = new Pirate("Jack Le Borgne", 0, 10);
    	Pirate pirate2 = new Pirate("Bill Jambe De Bois", 0, 10);
    	board.addPirate(pirate1);
    	board.addPirate(pirate2);
    	
    	// controller initialization
    	DiceControllerImpl diceController = new DiceControllerImpl();
    	GameController gameController = new GameController(boundary, diceController, board, pirate1, pirate2);
    	TakeItemController takeItemController = new TakeItemController();
    	TriggerCellController triggerCellController = new TriggerCellController(boundary, takeItemController);
    	MoveController moveController = new MoveController(diceController, triggerCellController, board);
    	BuyController buyController = new BuyController(takeItemController, market);
    	ActionController actionController = new ActionControllerImpl(gameController, buyController, moveController);
    	PlayerController playerController = new PlayerControllerImpl(gameController);
    	BoardController boardController = new BoardControllerImpl(gameController, board);
    	
    	// wiring IBoundary and IFunctionalKernel
    	boundary.setActionController(actionController);
    	boundary.setPlayerController(playerController);
    	boundary.setDiceController(diceController);
    	boundary.setBoardController(boardController);
    	
    	// launch
    	gameController.start();
    }

}