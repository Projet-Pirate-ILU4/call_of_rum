package fr.call_of_rum.util;

import java.util.function.Supplier;

public class LimitedSupplier<T> implements Supplier<T> {
	
	private final Supplier<T> supplier;
	private int maxAmount;
	private int amount;
	
	public LimitedSupplier(Supplier<T> supplier, int maxAmount, int amount) {
		this.supplier = supplier;
		this.maxAmount = maxAmount;
		this.amount = amount;
	}
	
	@Override
	public T get() {
		if (amount > 0) {
            amount--;
            return supplier.get();
        }
        return null;
	}
	
	public int getRemaining() {
		return amount;
	}
	
	public void refill(int amount) {
		this.amount += amount;
		if (this.amount > maxAmount)
			this.amount = maxAmount;
	}
	
}
