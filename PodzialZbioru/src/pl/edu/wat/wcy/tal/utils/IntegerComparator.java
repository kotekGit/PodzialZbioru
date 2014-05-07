package pl.edu.wat.wcy.tal.utils;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer x, Integer y) {
		if (x > y) {
			return -1;
		} else {
			return 1;
		}
	}

}
