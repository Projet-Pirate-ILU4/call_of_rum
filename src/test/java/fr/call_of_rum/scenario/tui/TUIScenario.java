package fr.call_of_rum.scenario.tui;

import java.lang.reflect.Field;
import java.util.function.Supplier;

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
	
	protected ConsoleBoundary boundary;
	
	protected ActionController actionController;
	protected BoardController boardController;
	protected DiceController diceController;
	protected GameController gameController;
	protected MarketController marketController;
	protected MoveController moveController;
	protected PlayerController playerController;
	
	public void setIfNull(String fieldName, Supplier<Object> newValue) {
        try {
            Class<?> clazz = TUIScenario.class;
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object currentValue = field.get(this);
            if (currentValue == null) {
                field.set(this, newValue.get());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void start() {
		if (boundary == null) boundary = new ConsoleBoundary();
		
		player1.setBoard(board);
		player2.setBoard(board);
		
		if (diceController == null) diceController = new DiceController(rng);
		if (playerController == null) playerController = new PlayerController(player1, player2);
		if (boardController == null) boardController = new BoardController(board, playerController);
		if (marketController == null) marketController = new MarketController(market, playerController);
		if (moveController == null) moveController = new MoveController(rng, boundary, diceController, playerController, board, player1, player2);
		if (actionController == null) actionController = new ActionController(marketController, moveController, boardController);
		if (gameController == null) gameController = new GameController(boundary, actionController, diceController, board, player1, player2);

		boundary.setActionController(actionController);
		boundary.setBoardController(boardController);
		boundary.setDiceController(diceController);
		boundary.setPlayerController(playerController);
		
		gameController.start();
	}

}
