package pl.edu.wat.wcy.tal.utils;

import java.util.List;

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
	
}
