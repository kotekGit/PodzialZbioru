package pl.edu.wat.wcy.tal.aproximate;

import pl.edu.wat.wcy.tal.Counter;
import pl.edu.wat.wcy.tal.utils.FileUtil;

/**
 * Klasa odpowiedzialna za implementację algorytmu KK.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class KarmarkarKarp {

    private int difference;
    /*
     * private Date startDate; private Date stopDate;
     */
    private long startDate;
    private long stopDate;
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

	startDate = System.nanoTime();
	for (int i = 1; i < arr.length; i++) {
	    difference = graph.differencing();
	}
	graph.color();
	stopDate = System.nanoTime();
	return difference;
    }

    /**
     * Metoda odpowiedzialna za wypisanie podzbiorów powstałych po wykonaniu
     * algorytmu KK.
     * 
     */
    public void print() {
	// graph.print(startDate,stopDate,difference);
    }

    public void saveTime() {
	long time = stopDate - startDate;
	time = time / 1000;
	Counter.getInstance().addKK(time);
	FileUtil.saveTime(time, "KK");
    }

}
