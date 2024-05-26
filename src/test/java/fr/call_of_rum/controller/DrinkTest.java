package fr.call_of_rum.controller;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.BoardFactory;
import fr.call_of_rum.model.inventory.Inventory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.ItemRegistry;
import fr.call_of_rum.model.item.liquid.HealthPotion;
import fr.call_of_rum.model.item.liquid.Rum;
import fr.call_of_rum.model.item.weapon.Dagger;
import fr.call_of_rum.model.market.Market;
import fr.call_of_rum.model.pirate.IntoxicationGauge;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;
import org.junit.Before;
import org.junit.Test;
import util.stub.BoundaryStub;

import java.util.Random;
import java.util.random.RandomGenerator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DrinkTest {
    private Pirate player1 ;
    private Pirate player2 ;

    protected Board board;
    private static final RandomGenerator RNG = new Random();
    private ActionController actionController;


    @Before
    public void setUp() {
        board = BoardFactory.getFactory()
                .setSpecialCaseOdds(0.0f)
                .build(new ItemRegistry(), RNG);
        player1 = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 10);
        player2 = new Pirate(Player.JACK_LE_BORGNE, 0, 10);
        initControllers();
    }

    private void initControllers() {
        DiceController diceController = new DiceController(DrinkTest.RNG);
        PlayerController playerController = new PlayerController(player1, player1);
        BoardController boardController = new BoardController(board, playerController);
        BoundaryStub boundaryStub = new BoundaryStub();
        MoveController moveController = new MoveController(DrinkTest.RNG, boundaryStub, diceController, playerController, board, player1, player2);
        MarketController marketController = new MarketController(new Market(), playerController);
        actionController = new ActionController(marketController, moveController, boardController);
    }

    @Test
    public void configuration1() {
        actionController.setCurrentPirate(player1);
        Inventory<Item> inventory = player1.getInventory();
        assertTrue(inventory.isEmpty());
        assertFalse(actionController.drink(0));
    }
    @Test
    public void configuration2() {
        actionController.setCurrentPirate(player1);
        Inventory<Item> inventory = player1.getInventory();
        inventory.add(new Rum());
        actionController.drink(0);
        assertTrue(actionController.drink(0));
    }

    @Test
    public void configuration3() {
        actionController.setCurrentPirate(player1);

        Inventory<Item> inventory = player1.getInventory();
        inventory.add(new HealthPotion());

        player1.setHealthPoints(5);
        int oldHealthPoint = player1.getHealthPoints();

        assertTrue(actionController.drink(0));
        int newHealthPoints = player1.getHealthPoints();
        assertTrue(newHealthPoints > oldHealthPoint);
    }

    @Test
    public void configuration4() {
        actionController.setCurrentPirate(player1);

        Inventory<Item> inventory = player1.getInventory();
        inventory.add(new Rum());

        IntoxicationGauge intoxicationGauge = player1.getIntoxicationGauge();
        float oldValueIntoxicationGauge = 0.0f;
        intoxicationGauge.setLevel(oldValueIntoxicationGauge);

        assertTrue(actionController.drink(0));

        float newValueIntoxicationGauge = intoxicationGauge.getLevel();

        assertTrue(newValueIntoxicationGauge> oldValueIntoxicationGauge);
    }
    @Test
    public void configuration5() {
        actionController.setCurrentPirate(player1);
        Inventory<Item> inventory = player1.getInventory();
        inventory.add(new Dagger());
        assertFalse(actionController.drink(0));
    }
    @Test
    public void configuration6() {
        actionController.setCurrentPirate(player1);
        Inventory<Item> inventory = player1.getInventory();
        inventory.add(new HealthPotion());
        assertTrue(actionController.drink(0));
        assertFalse(inventory.contains(new HealthPotion()));

    }
}