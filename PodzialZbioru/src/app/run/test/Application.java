package app.run.test;

import pl.edu.wat.wcy.tal.IPartition;
import pl.edu.wat.wcy.tal.aproximate.KarmarkarKarp;
import pl.edu.wat.wcy.tal.exact.BruteForce;
import pl.edu.wat.wcy.tal.exact.DynamicAlgorithm;
import pl.edu.wat.wcy.tal.utils.Console;

public class Application {

    //private String PATH = "C:\\Users\\Łukasz\\Desktop\\data.txt";

    /**
     * Kostruktor aplikacji.
     */
    public Application() {
	init();
    }

    /**
     * Metoda inicjalizująca.
     */
    private int init() {
	Console.welcome();
	Console.menu();
	return 0;
    }

    public static void run(int [] arr) {
	karmarkarKarp(arr);
	//dynamicAlgorithm(arr);
	//runAlgorithm(new BruteForce(), arr);
    }
    
    
    /**
     * metoda uruchamiająca algorytm KK.
     */
    private static void karmarkarKarp(int [] arr) {
	KarmarkarKarp KK = new KarmarkarKarp();
	if (arr != null) {
	    KK.solve(arr);
	    //KK.print();
	    KK.saveTime();
	}
    }

    private static void dynamicAlgorithm(int[] arr) {
	DynamicAlgorithm d = new DynamicAlgorithm();
	if (arr != null) {
	    d.solve(arr);
	    d.print();
	}
    }

    /**
     * Uruchamia algorytmy IPartition
     */
    private static void runAlgorithm(IPartition partition, int[] arr) {
	if (partition != null) {
	    if (arr != null) {
		partition.solve(arr);
		partition.print();
	    }
	}
    }

}
