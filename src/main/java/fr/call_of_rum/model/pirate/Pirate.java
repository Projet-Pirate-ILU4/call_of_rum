package fr.call_of_rum.model.pirate;

import fr.call_of_rum.model.board.Board;
import fr.call_of_rum.model.inventory.Inventory;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.item.weapon.Weapon;
import fr.call_of_rum.util.Player;

public class Pirate {
	
	private Player player;
	private int coins;
	private int healthPoints;
	private int maxHealthPoints;
	private Weapon equippedWeapon = null;
	private Inventory<Item> inventory = new Inventory<>(3);
	private IntoxicationGauge intoxicationGauge = new IntoxicationGauge();
	private Board board;
	private int location = 0;
	
	public Pirate(Player player, int coins, int maxHealthPoints) {
		this.player = player;
		this.coins = coins;
		this.maxHealthPoints = maxHealthPoints;
		this.healthPoints = maxHealthPoints;
	}
	
	public Player getPlayer() {
		return player;
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
	
	public Inventory<Item> getInventory() {
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
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other != null && other.getClass() == this.getClass()) {
			Pirate otherPirate = (Pirate) other;
			return this.player == otherPirate.player;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return player.hashCode();
	}
	
	@Override
	public String toString() {
		return player.toString().toLowerCase().replace('_', ' ');
	}
	
}
