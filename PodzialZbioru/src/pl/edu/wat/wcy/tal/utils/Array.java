package pl.edu.wat.wcy.tal.utils;

/**
 * Klasa pomocnicza, do przeprowadzania operacji na tablicach.
 * 
 * @author Mariusz Kielan
 *
 */
public class Array {
	
	/**
	 * Sumowanie elementów tablicy.
	 * 
	 * @param array - tablica do sumowania
	 * @return int - suma elementów w tablicy
	 */
	public static int sum(int[] array) {
		int sum = 0;
		
		for (int i : array) {
			sum += i;
		}
		
		return sum;
	}
	
	public static String toString(int[] array) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i + 1 < array.length) sb.append(" ");
		}
		
		return sb.toString();
	}
	
	public static String toString(Integer[] array) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i + 1 < array.length) sb.append(" ");
		}
		
		return sb.toString();
	}
}
