package pl.edu.wat.wcy.tal.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.edu.wat.wcy.tal.utils.StructureConverter;

public class Generator {

	private static final Logger log = Logger.getLogger(Generator.class.getName());
	private Random random;

	public Generator() {
		random = new Random();
	}

	/**
	 * Metoda generuje tablicę losowych elementów. Rozmiar tablicy określony
	 * jest parametrem n.
	 * 
	 * @author Łukasz Kotowski
	 * @param size
	 *            liczba elementów do wygenerowania.
	 * @param range
	 *            zakres z jakiego mają być generowane liczby
	 * @return Wygenerowana losowo tablica elementów.
	 */
	public int[] generateRandomData(int size, int range) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(range+1);
		}
		log.log(Level.INFO, "Wygenerowano losową tablicę: {0}. Liczba elementów: {1}. Zakres: [0-{2}] \n",
				new Object[] { Arrays.toString(array), size, range });
		return array;
	}
	
	/**
	 * Metoda pobiera dane z pliku. Każda liczba powinna być umieszczona w nowej linni.
	 * 
	 * @author Łukasz Kotowski
	 * @param path Ścieżka do pliku.
	 * @return tablica ze zbiorem liczb
	 */
	public int[] getDataFromFile(String path) {
		List<Integer> list = new ArrayList<Integer>();
		File file = new File(path);
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	try {
			    	int value = Integer.parseInt(text);
			        if (value >= 0) {
			        	list.add(value);
			        }
				} catch (NumberFormatException nfe) {
				}
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		int [] arr = StructureConverter.listToArray(list);
		log.log(Level.INFO, "Pobrano dane {0} z pliku: {1}", new Object[]{Arrays.toString(arr), path});
		return arr;
	}
	
}
