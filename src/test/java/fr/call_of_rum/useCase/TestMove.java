package fr.call_of_rum.useCase;

import fr.call_of_rum.boundary.ConsoleBoundary;
import fr.call_of_rum.controller.BuyController;
import fr.call_of_rum.controller.GameController;
import fr.call_of_rum.controller.MoveController;
import fr.call_of_rum.controller.TakeItemController;
import fr.call_of_rum.controller.accessible.*;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.artefact.Clover;
import fr.call_of_rum.model.item.liquid.Rum;
import fr.call_of_rum.model.item.weapon.Saber;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMove {
    protected ItemRegistry itemRegistry = new ItemRegistry();
    protected Board board = BoardFactory.getDefaultBoard(itemRegistry);
    protected Market market = new Market();
    protected Pirate player2 = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
    protected Pirate player1 = new Pirate(Player.JACK_LE_BORGNE, 0, 10);
    private ConsoleBoundary boundary = new ConsoleBoundary();
    private DiceControllerImpl diceController = new DiceControllerImpl();
    private GameController gameController;
    private TakeItemController takeItemController;
    private MoveController moveController;
    private BuyController buyController;
    private ActionController actionController;
    private PlayerController playerController;
    private BoardController boardController;

    @Before
    public void setUp() {
        start();
    }

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
        itemRegistry.registerItems(Clover::new, Rum::new, Saber::new);
    }


    @Test
    public void configuration1() {
        int bordSize = board.getBoardSize();
        board.movePirateTo(player1,bordSize-1);
        int positionStart = board.getPirateLocation(player1);
        diceController.rollDices();
        int diceValue = diceController.getDiceResult();
        moveController.movePirate(player1);
        int positionFinal = board.getPirateLocation(player1);
        assertTrue(positionFinal >= 1 && positionFinal < 12);
        assertEquals(positionFinal,(positionStart+diceValue)%bordSize);

    }

    @Test
    public void configuration2() {

    }
    @Test
    public void configuration3() {
        int bordSize = board.getBoardSize();
        board.movePirateTo(player1,bordSize-1);
        int positionStart = board.getPirateLocation(player1);
        diceController.rollDices();
        int diceValue = diceController.getDiceResult();
        moveController.movePirate(player1);
        int positionFinal = board.getPirateLocation(player1);
        assertTrue(diceValue > 1 && diceValue <= 12);
        assertEquals(positionFinal,(positionStart+diceValue)%bordSize);
    }

    @Test
    public void configuration4() {
        int diceValue;
        board.movePirateTo(player1,15);
        board.movePirateTo(player2,10);
        do {
            diceValue = diceController.getDiceResult();
        } while (diceValue != 5);
        moveController.movePirate(player2);
        assertEquals(board.getPirateLocation(player1),board.getPirateLocation(player2));
    }
}
