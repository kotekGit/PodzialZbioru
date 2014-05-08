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
}
