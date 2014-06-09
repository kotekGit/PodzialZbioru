package app.run.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.edu.wat.wcy.tal.IPartition;
import pl.edu.wat.wcy.tal.aproximate.KarmarkarKarp;
import pl.edu.wat.wcy.tal.data.Generator;
import pl.edu.wat.wcy.tal.exact.BruteForce;
import pl.edu.wat.wcy.tal.exact.DynamicAlgorithm;

public class Application {
	private static Logger log = Logger.getLogger("Application");

	private String PATH = "C:\\Users\\Łukasz\\Desktop\\data.txt";
	
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
		log.log(Level.INFO, "Uruchomiono aplikację.");
		String input = "";
		//new File("/PodzialZbioru/aproksymacyjny.txt"); //tworzy nowy plik na sessję;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!input.contains("@")) {
			System.out.println(Messages.MENU);
			try {
				input = br.readLine();
			} catch (IOException e) {
				log.log(Level.WARNING, "Błąd odczytu strumienia wejściowego!");
			}
			if (input.contains("1")) {
				log.log(Level.INFO, "Wybrano "+Messages.ALG_BRUTE_FORCE);
				runAlgorithm(new BruteForce());
			}
			else if (input.contains("2")) {
				log.log(Level.INFO, "Wybrano "+Messages.ALG_DYNAMICZNY);
				dynamicAlgorithm();
			} else if (input.contains("3")) {
				log.log(Level.INFO, "Wybrano "+Messages.ALG_APROKSYMACYJNY);
				karmarkarKarp();
			} else if (input.contains("@")){
				log.log(Level.INFO, Messages.MEMORY +"\n"+ Messages.KONIEC);
			} else {
				log.log(Level.WARNING, Messages.WARNING);
			}
		}
		return 0;
	}
	
	
	/**
	 * metoda uruchamiająca algorytm KK.
	 */
	private void karmarkarKarp() {
		//Tablica testowa: int [] arr = {73,40,30,20,13,6,3};
		KarmarkarKarp KK = new KarmarkarKarp();
		int arr[] = generator();
		if (arr != null) {
			KK.solve(arr);
			KK.print();	
		}
		KK = null;
	}
	
	private void dynamicAlgorithm() {
		DynamicAlgorithm d = new DynamicAlgorithm();
		int[] arr = generator();
		System.gc();
		if(arr != null) {
			d.solve(arr);
			d.print();
		}
	}
	
	/**
	 * Uruchamia algorytmy IPartition
	 */
	private void runAlgorithm(IPartition partition) {
		if(partition != null) {
			int[] arr = generator();
			
			if(arr != null) {
				partition.solve(arr);
				partition.print();
			}
		}
	}
	
	/**
	 * Generuje dane.
	 * @return tablica będąca zbiorem do podziału.
	 */
	private int[] generator() {
		Generator generator = new Generator();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
			System.out.println(Messages.GENERATOR);
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (input.contains("1")) {
				log.log(Level.INFO, "Wybrano "+ Messages.GEN_LOS);
				try {
					System.out.println(Messages.WPROWADZ_ILOSC);
					int size = Integer.parseInt(br.readLine());
					System.out.println(Messages.WPROWADZ_ZAKRES);
					int range = Integer.parseInt(br.readLine());
					return generator.generateRandomData(size, range);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (input.contains("2")) {
				log.log(Level.INFO, "Wybrano "+Messages.GEN_Z_PLIKU);
				return generator.getDataFromFile(PATH);
			} else {
				log.log(Level.WARNING, Messages.WARNING);
			}
		return null;
	}

}
