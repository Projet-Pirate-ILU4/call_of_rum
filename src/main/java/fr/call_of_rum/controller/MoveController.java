package fr.call_of_rum.controller;

import java.util.Optional;
import java.util.random.RandomGenerator;

import fr.call_of_rum.boundary.IBoundary;
import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.artefact.Bandana;
import fr.call_of_rum.model.item.artefact.Clover;
import fr.call_of_rum.model.item.artefact.Gunpowder;
import fr.call_of_rum.model.item.artefact.LucidityStone;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.CellType;
import fr.call_of_rum.util.ItemType;

public class MoveController {
	
	private RandomGenerator rng;
	
	private IBoundary boundary;
	
	private DiceController diceController;
	private PlayerController playerController;
	
	private Board board;
	private Pirate pirate1;
	private Pirate pirate2;
	
	public MoveController(RandomGenerator rng, IBoundary boundary, DiceController diceController, PlayerController playerController, Board board, Pirate pirate1, Pirate pirate2) {
		this.rng = rng;
		this.boundary = boundary;
		this.diceController = diceController;
		this.playerController = playerController;
		this.board = board;
		this.pirate1 = pirate1;
		this.pirate2 = pirate2;
	}
	
	private static final Item CLOVER = new Clover();
	
	private void triggerChestCell(Chest chest, Pirate pirate) {
		chest.setOpened(true);
		int chestCoins = chest.getCoins();
		if (pirate.getInventory().contains(CLOVER)) {
			chestCoins = (int) (1.5 * chestCoins);
		}
		pirate.setCoins(pirate.getCoins() + chestCoins);
		chest.setCoins(0);
		boolean tookItem = boundary.chestFound(chestCoins, chest.getItem().getType());
		if (tookItem) {
			playerController.takeItem(pirate, chest.getItem());
			chest.setItem(null);
		}
	}
	
	private void triggerOpenedChestCell(Chest chest) {
		Item chestItem = chest.getItem();
		Optional<ItemType> itemType = chestItem == null ? Optional.empty() : Optional.of(chestItem.getType());
		boundary.openedChestFound(chest.getCoins(), itemType);
		
	}
	
	private void triggerBombCell(Pirate pirate) {
		pirate.setHealthPoints(pirate.getHealthPoints() - 2);
		boundary.stepOnBomb();
	}
	
	private void triggerShortcut(Pirate pirate) {
		Pirate otherPirate = pirate.equals(pirate1) ? pirate2 : pirate1;
		board.movePirateTo(pirate, otherPirate);
		boundary.tookShortcut();
	}
	
	private void triggerMerchant() {
		// TODO implements
	}
	
	private static final float DEFAULT_STEALING_POTENTIAL = 0.2f;
	private static final Item BANDANA = new Bandana();
	
	private void steal(Pirate winner, Pirate loser) {
		Weapon equippedWeapon = winner.getEquippedWeapon();
		float stealingPotential = DEFAULT_STEALING_POTENTIAL;
		if (equippedWeapon != null)
			stealingPotential = equippedWeapon.getStealingPotential();
		if (winner.getInventory().contains(BANDANA))
			stealingPotential *= 1.5;
		int amountStealed = (int) (stealingPotential * loser.getCoins());
		winner.setCoins(winner.getCoins() + amountStealed);
		loser.setCoins(loser.getCoins() - amountStealed);
	}
	
	private static final int DEFAULT_DAMAGES = 1;
	
	private void harm(Pirate winner, Pirate loser) {
		Weapon equippedWeapon = winner.getEquippedWeapon();
		int damages = DEFAULT_DAMAGES;
		if (equippedWeapon != null)
			damages = equippedWeapon.getDamages();
		loser.setHealthPoints(loser.getHealthPoints() - damages);
	}
	
	private static final Item GUNPOWDER = new Gunpowder();
	
	private double getPirateFightBonus(Pirate pirate) {
		double fightBonus = 1.0; // start with even chances
		
		Weapon equippedWeapon = pirate.getEquippedWeapon();
		if (equippedWeapon != null)
			fightBonus += equippedWeapon.getFightBonus();
		
		if (pirate.getInventory().contains(GUNPOWDER))
			fightBonus = 1.5 * fightBonus;
		
		return fightBonus;
	}
	
	private static final Item LUCIDITY_STONE = new LucidityStone();
	
	private static final double EPSILON = 0.0001;
	
	private boolean isWinner(Pirate pirate, Pirate otherPirate) {
		// getting pirates intoxications
		double pirateIntoxication = pirate.getIntoxicationGauge().getLevel();
		double otherPirateIntoxication = otherPirate.getIntoxicationGauge().getLevel();
		
		// ignore intoxication effects if pirate have a lucidity stone
		if (pirate.getInventory().contains(LUCIDITY_STONE)) pirateIntoxication = 0.0;
		if (otherPirate.getInventory().contains(LUCIDITY_STONE)) otherPirateIntoxication = 0.0;
		
		// calculation of pirate chance bonuses
		double pirateBonus = getPirateFightBonus(pirate);
		double otherPirateBonus = getPirateFightBonus(otherPirate);
		
		// reducing chances by intoxication
		// EPSILON is used to avoid division by zero
		double pirateChance = pirateBonus * Math.max(1-pirateIntoxication, EPSILON);
		double otherPirateChance = otherPirateBonus * Math.max(1-otherPirateIntoxication, EPSILON);
		
		// relative chance: the chance of pirate to win against otherPirate
		double relativeChance = pirateChance / otherPirateChance;
		
		// calculation of the pirate winning chance knowing the relative chance
		double pirateWinChance = relativeChance/(1+relativeChance);
		
		return rng.nextDouble() < pirateWinChance;
	}
	
	private void triggerDuel() {
		Pirate winner;
		Pirate loser;
		if (this.isWinner(pirate1, pirate2)) {
            winner = pirate1;
            loser = pirate2;
        } else {
            winner = pirate2;
            loser = pirate1;
        }
		this.steal(winner, loser);
		this.harm(winner, loser);
		boundary.duel(winner.getPlayer());
	}
	
	public void triggerCell(Cell cell, Pirate pirate) {
		CellType cellType = cell.getType();
		switch (cellType) {
		case CHEST:
			triggerChestCell((Chest) cell, pirate);
			break;
		case OPENED_CHEST:
			triggerOpenedChestCell((Chest) cell);
			break;
		case BOMB:
			triggerBombCell(pirate);
			break;
		case SHORTCUT:
			triggerShortcut(pirate);
			break;
		case MERCHANT:
			triggerMerchant();
			break;
		default:
			break;
		}
		if (pirate1.getLocation() == pirate2.getLocation()) {
			triggerDuel();
		}
	}
	
	public void movePirate(Pirate pirate) {
		int pirateLocation = pirate.getLocation();
		int newLocation = pirateLocation + diceController.getDiceResult();
		board.movePirateTo(pirate, newLocation);
		this.triggerCell(board.getCell(newLocation), pirate);
	}
	
}
