package fr.call_of_rum.model.pirate;

import java.util.Optional;
import java.util.function.Predicate;

import fr.call_of_rum.model.item.Item;

public class Inventory {
	
	private static final int MAX_CAPACITY = 4;
	
	private Item[] items;
	
	public Inventory() {
		items = new Item[MAX_CAPACITY];
		for (int i = 0; i < MAX_CAPACITY; i++)
			items[i] = null;
	}
	
	private Optional<Integer> findFirst(Item item) {
		Predicate<Item> criteria;
		Item current;
		int i = 0;
		while (i < MAX_CAPACITY) {
			current = items[i];
			criteria = current == null || item == null ? it -> it == item : it -> it.equals(item);
			if (criteria.test(current))
				return Optional.of(i);
			i++;
		}
		return Optional.empty();
	}
	
	private Optional<Integer> getFirstFreeSlot() {
		return findFirst(null);
	}
	
	public void add(Item item) {
		Optional<Integer> freeSlot = getFirstFreeSlot();
		if (freeSlot.isEmpty())
			throw new NoFreeSlotException();
		items[freeSlot.get()] = item;
	}
	
	public void insert(Item item, int index) {
		items[index] = item;
	}
	
	public void removeItem(Item item) {
		Optional<Integer> itemSlot = findFirst(item);
		if (itemSlot.isEmpty()) return;
		items[itemSlot.get()] = null;
	}
	
	public Item get(int index) {
		return items[index];
	}
	
	public boolean contains(Item item) {
		return findFirst(item).isPresent();
	}
	
	private static final String BLANK_ITEM = "___";
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		int i;
		for (i = 0; i < MAX_CAPACITY-1; i++) {
			String element = items[i] == null ? BLANK_ITEM : items[0].toString();
			str.append(element);
			str.append(" | ");
		}
		String element = items[i] == null ? BLANK_ITEM : items[i].toString();
		str.append(element);
		str.append(" ]");
		return str.toString();
	}
	
}
