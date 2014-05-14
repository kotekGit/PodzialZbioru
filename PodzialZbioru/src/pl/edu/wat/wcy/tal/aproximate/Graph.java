package pl.edu.wat.wcy.tal.aproximate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		// Collections.sort(nodes, new NodeComparator());
	}

	/**
	 * Metoda realizuje operację różnicowania, czyli zamiany dwóch wierzchołków
	 * o największej wartości ich różnicą.
	 * 
	 * @return różnica pomiędzy dwoma aktualnie największymi względem wartości
	 *         wierzchołkami.
	 */
	public int differencing() {
		int[] max = findMax();
		int a = getNode(max[0]).getValue();
		int b = getNode(max[1]).getValue();
		addEdge(getNode(max[0]), getNode(max[1]));
		getNode(max[0]).setValue(a - b);
		getNode(max[1]).setValue(-1);
		return a - b;
	}

	/**
	 * Metoda odpowiada za kolorowanie grafu dwoma kolorami. Zaczynając od
	 * korzenia drzewa.
	 */
	public void color() {
		int[] max = findMax();
		Node n = getNode(max[0]);
		changeColor(n, Color.RED);
		colorIn(n);
	}

	/**
	 * Metoda odpowiedzialna za wypisanie podzbiorów powstałych po wykonaniu
	 * algorytmu KK.
	 */
	public void print(Date d1, Date d2, int difference) {
		List<Integer> s1 = new LinkedList<Integer>();
		List<Integer> s2 = new LinkedList<Integer>();
		for (Node n : nodes) {
			if (n.getColor() == Color.RED) {
				s1.add(n.getSelfValue());
			} else if (n.getColor() == Color.GREEN) {
				s2.add(n.getSelfValue());
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("\n-------Algorytm KK-------\n");
		sb.append("Data rozpoczęcia: "+d1+"\n");
		sb.append("Data zakończenia: "+d2+"\n");
		sb.append("Czas trwania: " + (d2.getTime() - d1.getTime()) + "[ms]\n");
		if (difference == 0) {
			sb.append("Zbiór podzielono na równe części.\n");
		} else {
			sb.append("Różnica pomiędzy zbiorami: "+difference+"\n");
		}

		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter("aproksymacyjny.txt", true)))) {
			out.flush();
			out.print(sb.toString()+"\nA = ");
			out.flush();
			String s = new String();
			int i = 0;
			for (Integer a : s1) {
				s = s + a + " ";
				if (i%200 == 199){
					s = s + "\n";
					out.print(s);
					out.flush();
					s="";
				}
				++i;
			}
			out.print(s+"\nB = ");
			s = ""; i=0;
			for (Integer b : s2) {
				s = s + b + " ";
				if (i%200 == 199){
					s = s + "\n";
					out.print(s);
					out.flush();
					s="";
				}
				++i;
			}
			out.print(s);
			out.flush();
			sb.append("Wyniki zapisano do pliku aproksymacyjny.txt\n");
		} catch (IOException e) {
			log.log(Level.WARNING, "Nie udało się zapisać wyniku do pliku!");
		}
		log.log(Level.INFO, sb.toString());
		nodes = null;
		System.gc();
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
		try {
			return nodes.get(index);	
		} catch (Exception e) {
			log.log(Level.WARNING, "Wystąpił błąd: Wartość poza zakresem!.\n");
		}
		return nodes.get(0);
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

	/**
	 * Metoda wyszukuje dwa wierzchołki o największej wartości.
	 * 
	 * @return indeksy największych co do wartości wierzchołków w zbiorze.
	 */
	private int[] findMax() {
		int maxOne = -999, maxTwo = -999;
		int idx1 = -1, idx2 = -1;
		int i = 0;
		for (Node n : nodes) {
			if (maxOne < n.getValue()) {
				maxTwo = maxOne;
				maxOne = n.getValue();
				idx2 = idx1;
				idx1 = i;
			} else if (maxTwo < n.getValue()) {
				maxTwo = n.getValue();
				idx2 = i;
			}
			i++;
		}
		int[] max = new int[2];
		max[0] = idx1;
		max[1] = idx2;
		return max;
	}

}
