package util;

import java.util.random.RandomGenerator;

public class FixedValueGenerator implements RandomGenerator {
	
	private int fixedValue;
	
	public FixedValueGenerator(int fixedValue) {
		this.fixedValue = fixedValue;
	}
	
	@Override
	public int nextInt() {
		return fixedValue;
	}
	
	@Override
	public int nextInt(int bound) {
		return fixedValue % bound;
	}
	
	@Override
	public long nextLong() {
		return fixedValue;
	}
	
	@Override
	public boolean nextBoolean() {
		return fixedValue % 2 == 0;
	}
	
	@Override
	public float nextFloat() {
		return fixedValue / (float) Integer.MAX_VALUE;
	}
	
	@Override
	public double nextDouble() {
		return fixedValue / (double) Integer.MAX_VALUE;
	}

}
