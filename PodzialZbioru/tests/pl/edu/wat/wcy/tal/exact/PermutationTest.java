package pl.edu.wat.wcy.tal.exact;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Mariusz Kielan
 *
 */
public class PermutationTest {

	ArrayList<Permutation> permutations = new ArrayList<Permutation>();
	int[][] arrays;
	
	@Before
	public void prepare() {
		arrays = new int[][] {
				{1,2,3,4,5,6}, 
				{1,2},
				{7},
				{3,2,5,6,1},
				{}
			};
		
		permutations.clear();
		
		for (int i = 0; i < arrays.length; i++) {
			permutations.add(new Permutation(arrays[i]));
		}
	}
	
	@Test
	public void sum() {
		int[][] notExcepted = new int[][] {
				{21, 3, 7, 17, 1},
				{0, 0, 0, 0, 1},
				{6, 2, 0, 1, 1},
				{5, 1, 0, 6, 1},
				{11, 1, 0, 7, 1},
			};
			
		int[][] excepted = new int[][] {
				{0, 0, 0, 0, 0},
				{6, 2, 7, 1, 0},
				{5, 1, 7, 6, 0},
				{11, 3, 7, 7, 0},
				{4, 3, 7, 5, 0},
			};
		
		boolean[][] existNext = new boolean[][] {
				{true, true, true, true, false},
				{true, true, false, true, false},
				{true, true, false, true, false},
				{true, false, false, true, false},
				{true, false, false, true, false},
			};
		
		for (int j = 0; j < Math.min(notExcepted.length, excepted.length); j ++)
		for (int i = 0; i < permutations.size(); i++) {
			
			System.out.println("j=" + j + ";i =" + i);
			System.out.println("binary code: " + Integer.toBinaryString(permutations.get(i).getCurrent()));
			System.out.println("array length: " + permutations.get(i).getArray().length);
			System.out.println("Current: " + permutations.get(i).getCurrent());
			System.out.println("power: " + (int)Math.pow(2,permutations.get(i).getArray().length));
			System.out.println("Not Excepted: " + notExcepted[j][i] + "," + permutations.get(i).sum());
			System.out.println("Excepted: " + excepted[j][i] + "," + permutations.get(i).sum());
			System.out.println("existNext: " + existNext[j][i] + ",perm: " + permutations.get(i).existNextPermutation());
			System.out.println("---");
			
			assertNotEquals(notExcepted[j][i], permutations.get(i).sum());
			assertEquals(excepted[j][i], permutations.get(i).sum());
			assertEquals(existNext[j][i], permutations.get(i).existNextPermutation());
			
			permutations.get(i).next();
			
		}
	}
}
