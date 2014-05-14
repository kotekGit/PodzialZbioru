package app.run.test;

/**
 * Klasa przechowująca wiadomości wyświetlane użytkownikowi.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class Messages {

	public static String MENU = ""
			+ "--------------------------------\n"
			+ "MENU GŁÓWNE:\n"
			+ " 1 - algorytm dokładny (brute force)\n"
			+ " 2 - algorytm dokładny (programowanie dynamiczne)\n"
			+ " 3 - algorytm aproksymacyjny\n"
			+ " @ - aby zakończyć\n"
			+ "--------------------------------\n"
			+ "Twój wybór: ";
	
	public static String GENERATOR = ""
			+ "--------------------------------\n"
			+ "MENU GENERATORA:\n"
			+ " 1 - dane losowe\n"
			+ " 2 - dane z pliku\n"
			+ "--------------------------------\n"
			+ "Twój wybór: ";
	
	
	public static String KONIEC = "Poprawnie zakończono działanie programu.";
	public static String MEMORY = "Wyczyszczono pamięć.";
	public static String ALG_DOKLADNY = "algorytm dokładny";
	public static String ALG_APROKSYMACYJNY = "algorytm aproksymacyjny - KK";
	public static String ALG_BRUTE_FORCE = "algorytm brute force";
	public static String ALG_DYNAMICZNY = "algorytm dynamiczny";	
	public static String GEN_LOS = "generator losowy";
	public static String GEN_Z_PLIKU = "dane z pliku";
	public static String WARNING = "Nieprawidłowa wartość!";
	public static String WPROWADZ_ZAKRES = "Zakres: ";
	public static String WPROWADZ_ILOSC = "Ilość elementów: ";

}
