package fr.call_of_rum.model.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import fr.call_of_rum.util.ShortcutMethod;

public class ItemRegistry {
	
	private List<Supplier<Item>> registeredItems;
	
	public ItemRegistry() {
		this.registeredItems = new ArrayList<>();
	}
	
	public ItemRegistry registerItem(Supplier<Item> itemSupplier) {
		registeredItems.add(itemSupplier);
		return this;
	}
	
	@ShortcutMethod
	public ItemRegistry registerItems(@SuppressWarnings("unchecked") Supplier<Item>... itemSuppliers) {
		for (Supplier<Item> itemSupplier : itemSuppliers)
			registerItem(itemSupplier);
		return this;
	}
	
	public int getSize() {
		return registeredItems.size();
	}
	
	public void clear() {
		registeredItems.clear();
	}
	
	/**
	 * This method get an <a href="Collection.html#unmodview">unmodifiable view</a> of all registered items
	 * @return <a href="Collection.html#unmodview">unmodifiable view</a> of all registered items
	 */
	public List<Supplier<Item>> getRegisteredItemView() {
		return Collections.unmodifiableList(registeredItems);
	}
	
}
