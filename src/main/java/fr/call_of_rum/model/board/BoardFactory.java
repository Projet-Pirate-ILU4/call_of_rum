package fr.call_of_rum.model.board;

import java.util.List;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

import fr.call_of_rum.model.board.cells.Cell;
import fr.call_of_rum.model.board.cells.Chest;
import fr.call_of_rum.model.board.cells.Land;
import fr.call_of_rum.model.board.cells.Trap;
import fr.call_of_rum.model.board.cells.TrapType;
import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.model.item.ItemRegistry;

public class BoardFactory {
	
	private int numberOfCells = 30;
	private int[] merchantPossibleCells = new int[] {15};
	private float specialCaseOdds = 0.3f;
	private float chestOdds = 0.6f;
	private int[] chestGoldBounds = new int[] {15, 40};
	
	public static BoardFactory getFactory() {
		return new BoardFactory();
	}
	
	public static Board getDefaultBoard(ItemRegistry itemRegistry, RandomGenerator rng) {
		return new BoardFactory().build(itemRegistry, rng);
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
	
	private Chest generateChest(int num, ItemRegistry itemRegistry, RandomGenerator rng) {
		int goldAmount = rng.nextInt(chestGoldBounds[0], chestGoldBounds[1]);
		Item item = null;
		if (itemRegistry.getSize() > 0) {
			int randomItemIndex = rng.nextInt(itemRegistry.getSize());
			List<Supplier<Item>> registeredItems = itemRegistry.getRegisteredItemView();
			item = registeredItems.get(randomItemIndex).get();
		}
		return new Chest(num, goldAmount, item);
	}
	
	private Trap pickTrap(int num, RandomGenerator rng) {
		TrapType[] trapTypes = TrapType.values();
		TrapType trapType = trapTypes[rng.nextInt(trapTypes.length)];
		return new Trap(num, trapType);
	}
	
	private Cell generateCell(int num, ItemRegistry itemRegistry, RandomGenerator rng) {
		if (rng.nextFloat() >= specialCaseOdds) return new Land(num);
		
		if (rng.nextFloat() < chestOdds) return generateChest(num, itemRegistry, rng);
		
		return pickTrap(num, rng);
	}
	
	public Board build(ItemRegistry itemRegistry, RandomGenerator rng) {
		Cell[] cells = new Cell[numberOfCells];
		// first and last cells are normal cells
		cells[0] = new Land(0);
		cells[numberOfCells-1] = new Land(29);
		// the other are ranomly generated
		for (int i = 1; i < numberOfCells - 1; i++) {
			cells[i] = generateCell(i, itemRegistry, rng);
		}
		int merchant = merchantPossibleCells[rng.nextInt(merchantPossibleCells.length)];
		return new Board(cells, numberOfCells, merchant);
	}
	
}
