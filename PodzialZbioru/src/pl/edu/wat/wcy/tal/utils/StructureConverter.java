package pl.edu.wat.wcy.tal.utils;

import java.util.List;
import java.util.PriorityQueue;

public class StructureConverter {
	
	/**
	 * Zamienia listę na tablicę.
	 * 
	 * @author Łukasz Kotowski
	 * @param list
	 * @return array 
	 */
	public static int[] listToArray(List<Integer> list) {
		Integer[] array= new Integer[list.size()];
		array = list.toArray(array);
		int [] arr = new int[list.size()];
		for (int i = 0; i<arr.length; i++) {
			arr[i] = array[i]; 
		}
		return arr;
	}
	
	/**
	 * Metoda zamienia tablicę integerów na kolejkę priorytetową.
	 * 
	 * @author Łukasz Kotowski
	 * @param arr tablica do konwersji na kolejkę
	 * @return PriorityQueue
	 */
	public static PriorityQueue<Integer> arrayToPriorityQueue(int[] arr) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(arr.length,
				new IntegerComparator());
		for (int val : arr) {
			queue.add(val);
		}
		return queue;
		
	}

}
