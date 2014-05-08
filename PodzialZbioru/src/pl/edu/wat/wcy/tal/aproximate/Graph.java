package pl.edu.wat.wcy.tal.aproximate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.edu.wat.wcy.tal.utils.NodeComparator;

/**
 * Klasa odpowiedzialna za zarządzanie grafem dla algorytmu KK.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class Graph {

	private List<Node> nodes;
	private static Logger log = Logger.getLogger(Graph.class.getName());

	/**
	 * Metoda inicjująca graf wartościami początkowymi.
	 * 
	 * @param array
	 *            tablica elementów zbioru, który ma zostać podzielony.
	 */
	public void init(int[] array) {
		nodes = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			addNode(new Node(i, array[i]));
		}
		Collections.sort(nodes, new NodeComparator());
	}

	/**
	 * Metoda realizuje operację różnicowania, czyli zamiany dwóch wierzchołków
	 * o największej wartości ich różnicą.
	 * 
	 * @return różnica pomiędzy dwoma aktualnie największymi względem wartości
	 *         wierzchołkami.
	 */
	public int differencing() {
		int a = getNode(0).getValue();
		int b = getNode(1).getValue();
		addEdge(getNode(0), getNode(1));
		getNode(0).setValue(a - b);
		getNode(1).setValue(-1);
		Collections.sort(nodes, new NodeComparator());
		return a - b;
	}

	/**
	 * Metoda odpowiada za kolorowanie grafu dwoma kolorami. Zaczynając od
	 * korzenia drzewa.
	 */
	public void color() {
		Node n = getNode(0);
		changeColor(n, Color.RED);
		colorIn(n);
	}

	/**
	 * Metoda odpowiedzialna za wypisanie podzbiorów powstałych po wykonaniu
	 * algorytmu KK.
	 */
	public void print() {
		String a = "", b = "";
		for (Node n : nodes) {
			if (n.getColor() == Color.RED) {
				a = a + n.getSelfValue() + " ";
			} else if (n.getColor() == Color.GREEN) {
				b = b + n.getSelfValue() + " ";
			}
		}
		log.log(Level.INFO,
				"Algorytm KK wykonał się poprawnie!\n Zbiór A = {0}\n Zbiór B = {1}",
				new Object[] { a, b });
	}

	/*
	 * ********************* Metody prywatne ********************
	 */

	/**
	 * Dodaje wierzchołek.
	 * 
	 * @param node
	 */
	private void addNode(Node node) {
		nodes.add(node);
	}

	/**
	 * Dodaje łuk pomiędzy wierzchołkami.
	 * 
	 * @param node1
	 *            wierzchołek pierwszy.
	 * @param node2
	 *            wierzchołek drugi.
	 */
	private void addEdge(Node node1, Node node2) {
		node1.getNeighbors().add(node2);
	}

	/**
	 * Metoda zwracająca wierzchołek o podanym indeksie z listy wszystkich
	 * wierzchołków.
	 * 
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		return nodes.get(index);
	}

	/**
	 * Metoda zmienia kolor wierzchołka.
	 * 
	 * @param node
	 *            wierzchołek.
	 * @param color
	 *            kolor na jaki ma zostać pokolorowany wierzchołek.
	 */
	private void changeColor(Node node, Color color) {
		node.setColor(color);
	}

	/**
	 * Metoda rekurencyjna odpowiedzialna za kolorowanie wierzchołków.
	 * 
	 * @param node
	 *            wierzchołek do pokolorowania
	 */
	private void colorIn(Node node) {
		Color color = secondColor(node);
		for (int i = 0; i < node.getNeighbors().size(); i++) {
			Node potomek = node.getNeighbors().get(i);
			changeColor(potomek, color);
			colorIn(potomek);
		}
	}

	/**
	 * Metoda pomocnicza zmieniająca aktualny kolor na przeciwny.
	 * 
	 * @param node
	 *            wierzchołek - rodzic.
	 * @return kolor inny niż rodzica.
	 */
	private Color secondColor(Node node) {
		if (node.getColor() == Color.RED) {
			return Color.GREEN;
		}
		return Color.RED;
	}

}
