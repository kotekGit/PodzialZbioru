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
				{3,2,5,6,1}
			};
		
		permutations.clear();
		
		for (int i = 0; i < arrays.length; i++) {
			permutations.add(new Permutation(arrays[i]));
		}
	}
	
	@Test
	public void sum() {
		int[][] notExcepted = new int[][] {
			{21, 3, 7, 17},
			{0, 0, 0, 0},
			{6, 2, 0, 1},
			{5, 1, 0, 6}
		};
		
		int[][] excepted = new int[][] {
			{0, 0, 0, 0},
			{6, 2, 7, 1},
			//{5, 1, 7, 6},
			//{11, 3, 7, 7},
		};
		
		boolean[][] existNext = new boolean[][] {
			{true, true, true, true},
			{true, true, false, true},
			{true, false, false, true},
			{true, false, false, true},
		};
		
		for (int j = 0; j < Math.min(notExcepted.length, excepted.length); j ++)
		for (int i = 0; i < permutations.size(); i++) {
			String a = Integer.toBinaryString(permutations.get(i).getCurrent());
			assertNotEquals(notExcepted[j][i], permutations.get(i).sum());

			assertEquals(excepted[j][i], permutations.get(i).sum());
			
			assertEquals(existNext[j][i], permutations.get(i).existNextPermutation());
			
			permutations.get(i).next();
		}
	}

}
