package pl.edu.wat.wcy.tal.exact;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Permutacje elementów podzbioru
 * 
 * @author Mariusz Kielan
 *
 */
public class Permutation {
	private int min;
	private int max;
	private int current;
	
	public Permutation(int min, int max) {
		this.min = min;
		this.max = max;
		this.current = min;
	}
	
	public Permutation(int min, int max, int current) {
		this.min = min;
		this.max = max;
		this.current = current;
	}
	
	public boolean isNextPermutation() {
		//TODO
		throw new NotImplementedException();
	}
	
	public Permutation getNextPartition() {
		//TODO
		throw new NotImplementedException();
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getCurrent() {
		return current;
	}
}
