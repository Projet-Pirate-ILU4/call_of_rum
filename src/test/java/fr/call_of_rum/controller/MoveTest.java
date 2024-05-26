package fr.call_of_rum.controller;

import static fr.call_of_rum.model.board.cells.TrapType.BOMB;
import static fr.call_of_rum.model.board.cells.TrapType.SHORTCUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.random.RandomGenerator;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.Trap;
import fr.call_of_rum.util.CellType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;
import util.FixedValueGenerator;
import util.stub.BoundaryStub;

public class MoveTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
	private static final RandomGenerator RNG = new Random();
	private static final int FIXED_VALUE = 3;
	private static final RandomGenerator FIXED_VALUE_GENERATOR = new FixedValueGenerator(FIXED_VALUE);
	
    protected Board board;
    protected Pirate player1;
    protected Pirate player2;
    
    private MoveController moveController;
    private DiceController diceController;
    private GameController gameController;
    private PlayerController playerController;

    @Before
    public void setUp() {
    	// build empty board
    	board = BoardFactory.getFactory()
    			.setSpecialCaseOdds(0.0f)
    			.build(new ItemRegistry(), RNG);
    	player1 = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
    	player2 = new Pirate(Player.JACK_LE_BORGNE, 0, 10);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    private void initControllers(RandomGenerator rng) {
    	diceController = new DiceController(rng);
    	playerController = new PlayerController(player1, player1);
    	BoundaryStub boundaryStub = new BoundaryStub();
    	moveController = new MoveController(rng, boundaryStub, diceController, playerController, board, player1, player2);
        gameController = new GameController(boundaryStub, null, diceController, board, player1, player2);
    }

    @Test
    public void configuration1() {
    	initControllers(FIXED_VALUE_GENERATOR);
        int bordSize = board.getBoardSize();
        board.movePirateTo(player1,bordSize-1);
        int positionStart = player1.getLocation();
        diceController.rollDices();
        int diceValue = diceController.getDicesResult();
        moveController.movePirate(player1);
        int positionFinal = player1.getLocation();
        assertTrue(positionFinal >= 1 && positionFinal < 12);
        assertEquals((positionStart+diceValue)%bordSize,positionFinal);

    }

    @Test
    public void configuration2() {
        initControllers(FIXED_VALUE_GENERATOR);
        int bordSize = board.getBoardSize();
    	board.movePirateTo(player1, board.getBoardSize() - diceController.getDicesResult()-1);
    	moveController.movePirate(player1);
        int positionFinal = player1.getLocation();

        assertEquals(bordSize-1,positionFinal);

    }
    
    @Test
    public void configuration3() {
    	initControllers(RNG);
        int bordSize = board.getBoardSize();
        board.movePirateTo(player1,bordSize-1);
        int positionStart = player1.getLocation();
        diceController.rollDices();
        int diceValue = diceController.getDicesResult();
        moveController.movePirate(player1);
        int positionFinal = player1.getLocation();
        assertTrue(diceValue > 1 && diceValue <= 12);
        assertEquals(positionFinal,(positionStart+diceValue)%bordSize);
    }

    @Test
    public void configuration4() {
    	initControllers(FIXED_VALUE_GENERATOR);
        diceController.rollDices();
        board.movePirateTo(player1,8);
        moveController.movePirate(player2);
        assertEquals(player1.getLocation(), player2.getLocation());
        assertEquals("C'est l'heure du DU DU DUEL !!!!\n", outContent.toString());
    }
    @Test
        public void configuration5() {
            int[] merchantCase = {1};
            board = BoardFactory.getFactory()
                    .setSpecialCaseOdds(1.0f)
                    .setChestOdds(0.0f)
                    .setMerchantPossibleCells(merchantCase)
                    .build(new ItemRegistry(), RNG);
            initControllers(FIXED_VALUE_GENERATOR);
            moveController = new MoveController(FIXED_VALUE_GENERATOR, new BoundaryStub(), diceController, playerController, board, player1, player2);

            diceController.rollDices();
            moveController.movePirate(player2);
            Cell cell = board.getCell(player2);

        String expectedOutput;
        if (cell.getType() == CellType.SHORTCUT) {
            expectedOutput = "Shorcutl\nC'est l'heure du DU DU DUEL !!!!\n";
        } else if (cell.getType() == CellType.BOMB) {
            expectedOutput = "BOUMMMMMMM !!!!\n";
        } else {
            expectedOutput = ""; // Ajoutez un comportement par défaut si nécessaire
        }

        assertEquals(expectedOutput, outContent.toString());
    }
}
