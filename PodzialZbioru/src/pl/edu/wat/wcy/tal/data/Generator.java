package pl.edu.wat.wcy.tal.data;

import pl.edu.wat.wcy.tal.utils.Distribution;

public class Generator {

/*	private static final Logger log = Logger.getLogger(Generator.class.getName());
	private Random random;

	public Generator() {
		random = new Random();
	}
	*/
	
	public static int[] generate(int zakres, double[] t) {
	    int[] array = new int[zakres];
	    for (int i=0; i<zakres; i++) {
		array[i] = Distribution.getRandom((int) t[0], t[1], t[2], zakres);
	    }
	    return array;
	}
	
/*
	*//**
	 * Metoda generuje tablicę losowych elementów. Rozmiar tablicy określony
	 * jest parametrem n.
	 * 
	 * @author Łukasz Kotowski
	 * @param size
	 *            liczba elementów do wygenerowania.
	 * @param range
	 *            zakres z jakiego mają być generowane liczby
	 * @return Wygenerowana losowo tablica elementów.
	 *//*
	public int[] generateRandomData(int size, int range) {
		int[] array = new int[size];
		String tablica = "";
		if (size < 1000){
			for (int i = 0; i < size; i++) {
				array[i] = random.nextInt(range+1);
			}
			tablica = Arrays.toString(array);
		}
		log.log(Level.INFO, "Wygenerowano losową tablicę: {0}.\nLiczba elementów: {1}. Zakres: [0-{2}] \n",
				new Object[] { tablica, size, range });
		return array;
	}
	
	*//**
	 * Metoda pobiera dane z pliku. Każda liczba powinna być umieszczona w nowej linni.
	 * 
	 * @author Łukasz Kotowski
	 * @param path Ścieżka do pliku.
	 * @return tablica ze zbiorem liczb
	 *//*
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
	}*/
	
}
