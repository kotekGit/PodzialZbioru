package pl.edu.wat.wcy.tal.exact;

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
		return current < (2 ^ array.length);
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
}
