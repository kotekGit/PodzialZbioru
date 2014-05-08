package pl.edu.wat.wcy.tal.aproximate;

/**
 * Klasa odpowiedzialna za implementację algorytmu KK.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class KarmarkarKarp {

	private int difference;
	private Graph graph;

	/**
	 * Konstruktor klasy KarmarkarKarp
	 */
	public KarmarkarKarp() {
		graph = new Graph();
		this.difference = 0;
	}

	/**
	 * Implementacja algorytmu Karmarkar'a Karpa.
	 * 
	 * @param arr
	 *            Tablica elementów zbioru do podziału.
	 * 
	 * @return int Różnica pomiędzy wartościami dwóch zbiorów powstałych w
	 *         wyniku podziału.
	 */
	public int solve(int[] arr) {
		graph.init(arr);

		for (int i = 1; i < arr.length; i++) {
			difference = graph.differencing();
		}
		graph.color();
		return difference;
	}

	/**
	 * Metoda odpowiedzialna za wypisanie podzbiorów powstałych po wykonaniu
	 * algorytmu KK.
	 * 
	 */
	public void print() {
		graph.print();
	}
}
