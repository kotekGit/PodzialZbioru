package pl.edu.wat.wcy.tal.exact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BruteForceTest {

	BruteForce bruteForce = new BruteForce();
	
	int[][] inputs = new int[][] {
			{1,2,3}, 
			{2,4,6},
			{3,3,5,9},
			{2,3,5,1},
			{1,4,7,5,3,5,1,3}
		};
	
	int[] exceptedResults = new int[] {0, 0, 0, 1, 1};
	
	@Before
	public void prepare() {
		
	}
	
	@Test
	public void test() {

		for(int i = 0; i < exceptedResults.length; i++) {
			System.out.println("Step " + (i + 1) + "/" + exceptedResults.length);
			assertEquals(exceptedResults[i], bruteForce.partition(inputs[i]));
		}
	}

}
