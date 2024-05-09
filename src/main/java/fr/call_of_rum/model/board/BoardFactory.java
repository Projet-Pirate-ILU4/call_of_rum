package fr.call_of_rum.model.board;

import java.util.Random;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.board.cells.Land;
import fr.call_of_rum.model.board.cells.Trap;
import fr.call_of_rum.model.board.cells.TrapType;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.ItemRegistry;

public class BoardFactory {
	
	private static final Random RNG = new Random();
	
	private int numberOfCells = 30;
	private int[] merchantPossibleCells = new int[] {15};
	private float specialCaseOdds = 0.3f;
	private float chestOdds = 0.6f;
	private int[] chestGoldBounds = new int[] {15, 40};
	
	public static BoardFactory getFactory() {
		return new BoardFactory();
	}
	
	public static Board getDefaultBoard(ItemRegistry itemRegistry) {
		return new BoardFactory().build(itemRegistry);
	}
	
	public BoardFactory setNumberOfCells(int numberOfCells) {
		this.numberOfCells = numberOfCells;
		return this;
	}
	
	public BoardFactory setMerchantPossibleCells(int[] merchantPossibleCells) {
		this.merchantPossibleCells = merchantPossibleCells;
		return this;
	}
	
	public BoardFactory setSpecialCaseOdds(float specialCaseOdds) {
		this.specialCaseOdds = specialCaseOdds;
		return this;
	}
	
	public BoardFactory setChestOdds(float chestOdds) {
		this.chestOdds = chestOdds;
		return this;
	}
	
	public BoardFactory setChestGoldBounds(int[] chestGoldBounds) {
		this.chestGoldBounds = chestGoldBounds;
		return this;
	}
	
	private Chest generateChest(int num, ItemRegistry itemRegistry) {
		int goldAmount = RNG.nextInt(chestGoldBounds[0], chestGoldBounds[1]);
		Item item = null;
		if (itemRegistry.getSize() > 0) {
			int randomItemIndex = RNG.nextInt(itemRegistry.getSize());
			item = itemRegistry.getInstance(randomItemIndex);
		}
		return new Chest(num, goldAmount, item);
	}
	
	private Trap pickTrap(int num) {
		TrapType[] trapTypes = TrapType.values();
		TrapType trapType = trapTypes[RNG.nextInt(trapTypes.length)];
		return new Trap(num, trapType);
	}
	
	private Cell generateCell(int num, ItemRegistry itemRegistry) {
		if (RNG.nextFloat() >= specialCaseOdds) return new Land(num);
		
		if (RNG.nextFloat() < chestOdds) return generateChest(num, itemRegistry);
		
		return pickTrap(num);
	}
	
	public Board build(ItemRegistry itemRegistry) {
		Cell[] cells = new Cell[numberOfCells];
		for (int i = 0; i < numberOfCells; i++) {
			cells[i] = generateCell(i, itemRegistry);
		}
		int merchant = merchantPossibleCells[RNG.nextInt(merchantPossibleCells.length)];
		return new Board(cells, numberOfCells, merchant);
	}
	
}
