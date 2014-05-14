package pl.edu.wat.wcy.tal.exact;

import java.util.ArrayList;

/**
 * Permutacje elementów podzbioru
 * 
 * @author Mariusz Kielan
 *
 */
public class Permutation {
	private int current = 0;
	private int[] array;
	private boolean change = true;
	private int sum;
	
	/**
	 * @param array
	 * 				zbiór liczb
	 */
	public Permutation(int[] array) {
		this.array = array;
	}
	
	public boolean existNextPermutation() {
		return array.length > 0 && current < ((int)Math.pow(2,array.length) - 1);
	}
	
	public boolean existNextSymetricPermutation() {
		return array.length > 0 && current < (((int)Math.pow(2,array.length)/2) - 1);
	}
	
	/**
	 * Zwraca bądź generuje sumę elementów permutacji.
	 * 
	 * @return int
	 */
	public int sum() {
		if(change) {
			sum = 0;
			
			char[] tmp = Integer.toBinaryString(current).toCharArray();
			for (int i = 0; i < tmp.length; i++) {
				if(tmp[tmp.length - i - 1]=='1') sum += array[array.length - i - 1]; // elementy tablicy od końca dla zachowania porządku
			}
			
			change = false;
		}
		
		return sum;
	}
	
	/**
	 * Przełączenie na kolejną permutację.
	 */
	public void next() {
		if(existNextPermutation()) {
			current++;
			change = true;
		}
	}
	
	/**
	 * Przełączenie na poprzednią permutację.
	 */
	public void prev() {
		if(current > 0) {
			current--;
			change = true;
		}
	}
	
	public int getCurrent() {
		return current;
	}
	
	public int[] getArray() {
		return array;
	}
	
	public Integer[] firstArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		char[] tmp = Integer.toBinaryString(current).toCharArray();
		
		for (int i = 0; i < tmp.length; i++) {
			if(tmp[tmp.length - i - 1]=='1') list.add(array[array.length - i - 1]); // elementy tablicy od końca dla zachowania porządku
		}
		
		return list.toArray(new Integer[list.size()]);
	}
	
	public Integer[] secondArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		char[] tmp = Integer.toBinaryString(current).toCharArray();
		
		for (int i = 0; i < tmp.length; i++) {
			if(tmp[tmp.length - i - 1]=='0') list.add(array[array.length - i - 1]); // elementy tablicy od końca dla zachowania porządku
		}
		
		return list.toArray(new Integer[list.size()]);
	}
}
