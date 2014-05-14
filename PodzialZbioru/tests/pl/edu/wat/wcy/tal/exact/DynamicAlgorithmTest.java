package pl.edu.wat.wcy.tal.exact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DynamicAlgorithmTest {

	DynamicAlgorithm dynamicAlgorithm = new DynamicAlgorithm();
	
	int[][] cases;
	boolean[] results;
	
	@Before
	public void prepare() {
		cases = new int[][] {
				{1,2,3}, 
				{2,4,6},
				{3,3,5,9},
				{2,3,5,1},
				{1,4,7,5,3,5,1,3},
				{2,4,5,2,9,4,9,5,9,7,8,5},
				{27, 88, 45, 123},
				{1, 20, 10, 30, 1}
			};
		
		results = new boolean[] {
				true,
				true,
				false,
				false,
				false,
				false,
				false,
				true,
		};
	}
	
	@Test
	public void test() {
		
		for(int i = 0; i < Math.min(results.length, cases.length); i++) {
			assertEquals(dynamicAlgorithm.partition(cases[i]), results[i]);
		}
		
	}

}
