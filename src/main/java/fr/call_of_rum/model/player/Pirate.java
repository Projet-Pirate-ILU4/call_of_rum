package fr.call_of_rum.model.player;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.Liquid;
import fr.call_of_rum.model.item.Weapon;

public class Pirate {
	
	private int coins;
	private int healthPoints;
	private int maxHealthPoints;
	private Weapon equippedWeapon = null;
	private Inventory inventory = new Inventory();
	private IntoxicationGauge intoxicationGauge = new IntoxicationGauge();
	private Board board;
	
	
	public Pirate(int coins, int maxHealthPoints) {
		this.coins = coins;
		this.maxHealthPoints = maxHealthPoints;
		this.healthPoints = maxHealthPoints;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int newAmount) {
		this.coins = newAmount;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	public void setHealthPoints(int newHealthPointsAmount) {
		healthPoints = newHealthPointsAmount;
	}
	
	public int getMaxHealth() {
		return maxHealthPoints;
	}
	
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	
	public void equipWeapon(Weapon newEquippedWeapon) {
		equippedWeapon = newEquippedWeapon;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void give(Item item) {
		item.setOwner(this);
		inventory.add(item);
	}
	
	public void drink(Liquid liquid) {
		liquid.setOwner(this);
		liquid.use();
	}
	
	public IntoxicationGauge getIntoxicationGauge() {
		return intoxicationGauge;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board newBoard) {
		board = newBoard;
	}
	
}
