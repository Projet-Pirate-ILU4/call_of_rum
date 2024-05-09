package fr.call_of_rum.model.item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import fr.call_of_rum.util.ShortcutMethod;

public class ItemRegistry {
	
	private List<Class<? extends Item>> registeredItems;
	
	public ItemRegistry() {
		this.registeredItems = new ArrayList<>();
	}
	
	public ItemRegistry registerItem(Class<? extends Item> itemClass) {
		registeredItems.add(itemClass);
		return this;
	}
	
	@ShortcutMethod
	public ItemRegistry registerItems(@SuppressWarnings("unchecked") Class<? extends Item>... itemClasses) {
		for (Class<? extends Item> itemClass : itemClasses)
			registerItem(itemClass);
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
	public List<Class<? extends Item>> getRegisteredItemView() {
		return Collections.unmodifiableList(registeredItems);
	}
	
	public Item getInstance(int index) {
		try {
			Class<? extends Item> itemClass = registeredItems.get(index);
			Constructor<? extends Item> constructor = itemClass.getConstructor();
			return constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Logger.getLogger(ItemRegistry.class.getName()).severe(e.getMessage());
		}
		return null;
	}
	
}
