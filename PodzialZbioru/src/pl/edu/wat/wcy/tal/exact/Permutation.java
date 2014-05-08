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
		return current < array.length;
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
				if(tmp[i]=='1') sum += array[i];
			}
			
			change = false;
		}
		
		return sum;
	}
	
	/**
	 * Przełączenie na kolejną permutację.
	 */
	public void next() {
		current++;
		change = true;
	}
	
	/**
	 * Przełączenie na poprzednią permutację.
	 */
	public void prev() {
		current--;
		change = true;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public int[] getArray() {
		return array;
	}
}
