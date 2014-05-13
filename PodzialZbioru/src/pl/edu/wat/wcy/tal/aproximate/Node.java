package pl.edu.wat.wcy.tal.aproximate;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private int value;
	private int selfValue;
	private Color color;
	private List<Node> neighbors;
	
	public Node(int id, int value) {
		this.value = value;
		this.selfValue = value;
		this.neighbors = new LinkedList<>();
		this.color = Color.TRANSPARENT;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSelfValue() {
		return selfValue;
	}

	public void setSelfValue(int selfValue) {
		this.selfValue = selfValue;
	}
}
