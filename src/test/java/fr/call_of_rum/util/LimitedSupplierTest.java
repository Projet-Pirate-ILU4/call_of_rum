package fr.call_of_rum.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class LimitedSupplierTest {
	
	private static final int MAX_CAPACITY = 2;
	private static final int INITIAL_CAPACITY = 1;
	
	private LimitedSupplier<Integer> limitedSupplier;
	
	@Before
	public void setUp() {
		limitedSupplier = new LimitedSupplier<>(
				() -> 0,
				MAX_CAPACITY,
				INITIAL_CAPACITY
			);
	}

	@Test
	public void limitationTest() {
		for (int i = 0; i < INITIAL_CAPACITY; i++) {
			assertNotNull(limitedSupplier.get());
		}
		assertNull(limitedSupplier.get());
	}
	
	@Test
	public void refillTest() {
		limitedSupplier.refill(MAX_CAPACITY - limitedSupplier.getRemaining());
		for (int i = 0; i < MAX_CAPACITY; i++) {
			assertNotNull(limitedSupplier.get());
		}
		assertNull(limitedSupplier.get());
	}
	
	@Test
	public void maxCapacityTest() {
		limitedSupplier.refill(MAX_CAPACITY);
		for (int i = 0; i < MAX_CAPACITY; i++) {
			assertNotNull(limitedSupplier.get());
		}
		assertNull(limitedSupplier.get());
	}

}
