package pl.edu.wat.wcy.tal.exact;

import pl.edu.wat.wcy.tal.utils.Array;

public class DynamicAlgorithm {
	
	/**
	 * @author Mariusz Kielan
	 */
	public boolean partition(int[] array) {
		int n = array.length;
		int i, j;		
		int sum = Array.sum(array);
		int L = sum / 2;
		
		if (sum%2 != 0)  
			return false;
			
		// zainicjowanie tablicy	
		boolean[][] part = new boolean[n][L + 1];
		
		for(j = 0; j <= L; j++) 
			part[0][j] = j == 0 || j == array[0];
		
		for(i = 1; i < n; i++) {
			for(j = 0; j <= L; j++) {
				part[i][j] = 
						part[i - 1][j] 
						|| (array[i] <= j 
							&& part[i - 1][ j - array[i]]);
			}
		}
		
		return part[n - 1][L];
	}
}
