package app.run.test;

import pl.edu.wat.wcy.tal.IPartition;
import pl.edu.wat.wcy.tal.aproximate.KarmarkarKarp;
import pl.edu.wat.wcy.tal.exact.BruteForce;
import pl.edu.wat.wcy.tal.exact.DynamicAlgorithm;
import pl.edu.wat.wcy.tal.utils.Console;

public class Application {


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

    public static void run(int [] arr, int mode) {
	switch (mode) {
    	case 1: all(arr); break;
    	case 2: runAlgorithm(new BruteForce(), arr);break;
    	case 3: dynamicAlgorithm(arr);break;
    	case 4: karmarkarKarp(arr);break;
    	default: break;
	}

    }
    
    private static void all(int [] arr) {
	runAlgorithm(new BruteForce(), arr);
	dynamicAlgorithm(arr);
	karmarkarKarp(arr);
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
	    //d.print();
	    d.saveTime();
	}
    }

    /**
     * Uruchamia algorytmy IPartition
     */
    private static void runAlgorithm(IPartition partition, int[] arr) {
	if (partition != null) {
	    if (arr != null) {
		partition.solve(arr);
		//partition.print();
		partition.saveTime();
	    }
	}
    }
    

}
