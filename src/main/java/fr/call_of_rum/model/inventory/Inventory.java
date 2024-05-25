package fr.call_of_rum.model.inventory;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.ItemType;

public class Inventory<T extends Item> {
	
	private static final BiPredicate<Optional<Item>, Predicate<Item>> ON_NON_NULL = (i, p) -> i.isPresent() && p.test(i.get());
	
	private int maxCapacity;
	private Item[] items;
	
	public Inventory(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		items = new Item[maxCapacity];
		for (int i = 0; i < maxCapacity; i++)
			items[i] = null;
	}
	
	private Optional<Integer> findFirst(Predicate<Optional<Item>> prediacate) {
		int i = 0;
		while (i < maxCapacity) {
			if (prediacate.test(Optional.ofNullable(items[i])))
				return Optional.of(i);
			i++;
		}
		return Optional.empty();
	}
	
	private Optional<Integer> getFirstFreeSlot() {
		return findFirst(Optional::isEmpty);
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
		Optional<Integer> itemSlot = findFirst(opti -> ON_NON_NULL.test(opti, i -> i.equals(item)));
		if (itemSlot.isEmpty()) return;
		items[itemSlot.get()] = null;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) items[index];
	}
	
	public boolean contains(Item item) {
		return findFirst(opti -> ON_NON_NULL.test(opti, i -> i.equals(item))).isPresent();
	}
	
	public boolean contains(ItemType itemType) {
		return findFirst(opti -> ON_NON_NULL.test(opti, i -> i.getType().equals(itemType))).isPresent();
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
