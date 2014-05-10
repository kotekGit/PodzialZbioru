package pl.edu.wat.wcy.tal.exact;

import pl.edu.wat.wcy.tal.IOptPartition;
import pl.edu.wat.wcy.tal.utils.Array;

/**
 * Rozwiązywanie problemu podziału zbioru algorytmem brute force.
 * 
 * @author Mariusz Kielan
 */
public class BruteForce implements IOptPartition {
	//TODO poprawić algorytm (nie wychodzi dla ostatniego przypadku z unit testów)
	//TODO uwzględnić fakt, że problem jest symetryczny (połowa sprawdzeń)
	@Override
	public int partition(int[] array) {
		int totalSum = Array.sum(array);
		
		Permutation permutation = new Permutation(array);
		int sum = permutation.sum();
		
		while(permutation.existNextPermutation()) {
			permutation.next();
			
			if(permutation.sum() == totalSum / 2) return 0; 
			
			if(
				Math.abs(totalSum - sum) 
				< 
				Math.abs(totalSum) - permutation.sum()
			)
				sum = permutation.sum();
		}
		
		return Math.abs(totalSum - 2 * sum);
	}
}
