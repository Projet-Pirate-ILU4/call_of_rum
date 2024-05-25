package fr.call_of_rum.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.random.RandomGenerator;

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
	
	private static final RandomGenerator RNG = new Random();
	private static final int FIXED_VALUE = 3;
	private static final RandomGenerator FIXED_VALUE_GENERATOR = new FixedValueGenerator(FIXED_VALUE);
	
    protected Board board;
    protected Pirate player1;
    protected Pirate player2;
    
    private MoveController moveController;
    private DiceController diceController;
    private PlayerController playerController;

    @Before
    public void setUp() {
    	// build empty board
    	board = BoardFactory.getFactory()
    			.setSpecialCaseOdds(0.0f)
    			.build(new ItemRegistry(), RNG);
    	player1 = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
    	player2 = new Pirate(Player.JACK_LE_BORGNE, 0, 10);
    }
    
    private void initControllers(RandomGenerator rng) {
    	diceController = new DiceController(rng);
    	playerController = new PlayerController(player1, player1);
    	BoundaryStub boundaryStub = new BoundaryStub();
    	moveController = new MoveController(rng, boundaryStub, diceController, playerController, board, player1, player2);
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
        assertEquals(positionFinal,(positionStart+diceValue)%bordSize);

    }

    @Test
    public void configuration2() {
    	// this test belongs to GameController testing
    	/*
    	initControllers(FIXED_VALUE_GENERATOR);
    	diceController.rollDices();
    	board.movePirateTo(player1, board.getBoardSize() - diceController.getDicesResult());
    	moveController.movePirate(player1);
    	*/
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
        moveController.movePirate(player2);
        assertEquals(player1.getLocation(), player2.getLocation());
    }
}
