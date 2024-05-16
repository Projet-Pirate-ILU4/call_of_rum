package fr.call_of_rum.model.pirate;

import java.util.Optional;
import java.util.function.Predicate;

import fr.call_of_rum.model.item.Item;

public class Inventory<T extends Item> {
	
	private int maxCapacity;
	private Item[] items;
	
	public Inventory(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		items = new Item[maxCapacity];
		for (int i = 0; i < maxCapacity; i++)
			items[i] = null;
	}
	
	private Optional<Integer> findFirst(Item item) {
		Predicate<Item> criteria;
		Item current;
		int i = 0;
		while (i < maxCapacity) {
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
	
	public boolean isFull() {
		return getFirstFreeSlot().isEmpty();
	}
	
	public void add(T item) {
		Optional<Integer> freeSlot = getFirstFreeSlot();
		if (freeSlot.isEmpty())
			throw new NoFreeSlotException();
		items[freeSlot.get()] = item;
	}
	
	public void insert(T item, int index) {
		items[index] = item;
	}
	
	public void remove(int index) {
		items[index] = null;
	}
	
	public void remove(T item) {
		Optional<Integer> itemSlot = findFirst(item);
		if (itemSlot.isEmpty()) return;
		items[itemSlot.get()] = null;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) items[index];
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
		for (i = 0; i < maxCapacity-1; i++) {
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
