package fr.call_of_rum;

import fr.call_of_rum.boundary.ConsoleBoundary;
import fr.call_of_rum.controller.ActionController;
import fr.call_of_rum.controller.BoardController;
import fr.call_of_rum.controller.DiceController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MarketController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.PlayerController;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.artefact.Clover;
import fr.call_of_rum.model.item.liquid.Rum;
import fr.call_of_rum.model.item.weapon.Saber;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;

public class Main {
    
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
    	@SuppressWarnings("unchecked")
    	ItemRegistry itemRegistry = new ItemRegistry().registerItems(Clover::new, Rum::new, Saber::new);
		Board board = BoardFactory.getDefaultBoard(itemRegistry);
    	Market market = new Market();
    	Pirate pirate1 = new Pirate(Player.JACK_LE_BORGNE, 0, 10);
    	Pirate pirate2 = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
    	pirate1.setBoard(board);
    	pirate2.setBoard(board);
    	
    	// controller initialization
    	DiceController diceController = new DiceController();
		PlayerController playerController = new PlayerController(pirate1, pirate2);
		BoardController boardController = new BoardController(board, playerController);
		MarketController marketController = new MarketController(market, playerController);
		MoveController moveController = new MoveController(boundary, diceController, playerController, board, pirate1, pirate2);
		ActionController actionController = new ActionController(marketController, moveController, boardController);
		GameController gameController = new GameController(boundary, actionController, diceController, board, pirate1, pirate2);
    	
    	// wiring IBoundary and IFunctionalKernel
    	boundary.setActionController(actionController);
    	boundary.setPlayerController(playerController);
    	boundary.setDiceController(diceController);
    	boundary.setBoardController(boardController);
    	
    	// launch
    	gameController.start();
    }

}