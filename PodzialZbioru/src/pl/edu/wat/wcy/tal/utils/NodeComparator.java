package pl.edu.wat.wcy.tal.utils;

import java.util.Comparator;

import pl.edu.wat.wcy.tal.aproximate.Node;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.getValue() < o2.getValue()) {
			return 1;
		}
		return -1;
	}

}
