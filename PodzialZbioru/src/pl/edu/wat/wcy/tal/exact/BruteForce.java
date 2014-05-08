package pl.edu.wat.wcy.tal.exact;

import pl.edu.wat.wcy.tal.IOptPartition;
import pl.edu.wat.wcy.tal.utils.Array;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BruteForce implements IOptPartition {

	/**
	 * @author Mariusz Kielan
	 */
	@Override
	public int partition(int[] array) {
		int totalSum = Array.sum(array);
		
		Permutation permutation = new Permutation(1, array.length);
		
		while(permutation.isNextPermutation()) {
			Permutation tmp = permutation.getNextPartition();
			
			if(sumSelected(array, tmp) == totalSum / 2) return 0; 
			
			if(
				Math.abs(totalSum - sumSelected(array, tmp)) 
				< 
				Math.abs(totalSum) - sumSelected(array, permutation)
			)
				permutation = tmp;
		}
		
		return Math.abs(totalSum - 2 * sumSelected(array, permutation));
	}
	
	public static int sumSelected(int[] array, Permutation permutation) {
		throw new NotImplementedException();
	}
}
