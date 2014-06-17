package app.run.test;

/**
 * Klasa przechowująca wiadomości wyświetlane użytkownikowi.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class Messages {
    
    public static String KONIEC = "Poprawnie zakonczono dzialanie programu.";
    public static String ALG_KK = "Algorytm KK ";
    public static String ALG_BRUTE_FORCE = "Algorytm Brute Force ";
    public static String ALG_DYNAMICZNY = "Algorytm Dynamiczny ";
    public static String GEN_LOS = "generator losowy";
    public static String GEN_Z_PLIKU = "dane z pliku";
    public static String WARNING = "Nieprawidlowa wartosc!";
    public static String WPROWADZ_ZAKRES = "Zakres: ";
    public static String WPROWADZ_ILOSC = "Ilosc elementow: ";
    public static String BLAD_ODCZYTU = "Blad odczytu strumienia wejsciowego!";
    public static String PARAMETR_A = "Podaj parametr a: ";
    public static String PARAMETR_B = "Podaj parametr b: ";
    public static String WYNIK = "Wynik wykonania: ";
    public static String NANO = " [ns]";
    public static String MIKRO = " [us]";
    public static String DIFF = "Różnica pomiedzy KK i BF: ";
    public static String PROCENTOWO = "Procentowo: ";
    public static String PROPORCJA = " (KK/BF)";

    
    public static String WELCOME = "--------------------------------\n"
	    + "WOJSKOWA AKADEMIA TECHNICZNA\n"
	    + "TECHNIKI ALGORYTMICZNE\n"
	    + "PROBLEM PODZIALU ZBIORU\n"
	    + "ALGORYTMY:\n"
	    + " - Brute Force, \n - Programowania Dynamicznego,\n"
	    + " - Karmarkara Karpa'a.\n"
	    + "PROWADZACY: mgr inz. Tomasz DROZDOWSKI\n"
	    + "WYKONALI: Mariusz KIELAN, Lukasz KOTOWSKI";
    
    
    public static String MENU = "" + "--------------------------------\n"
	    + "MENU\n"
	    + " 1. Generator\n"
	    + " 2. Koniec\n";
    
    public static String MODE = "" + "--------------------------------\n"
	    + "TRYB:\n"
	    + " 1. Seria (wszystkie):\n"
	    + " 2. Seria (wybrany):\n"
	    + "   a. " + ALG_BRUTE_FORCE + "\n"
	    + "   b. " + ALG_DYNAMICZNY + "\n"
	    + "   c. " + ALG_KK + "\n"
	    + " 3. Pojedyncze uruchomienie:\n"
	    + "   a. " + ALG_BRUTE_FORCE + "\n"
	    + "   b. " + ALG_DYNAMICZNY + "\n"
	    + "   c. " + ALG_KK + "\n"
	    + " 4. Porównanie KK z BF\n"
	    + " 5. Koniec\n";

    public static String GENERATOR_ROZKLAD = "" + "--------------------------------\n"
	    + "WYBIERZ ROZKLAD:\n"
	    + " 1. JEDNOSTAJNY (b>a)\n"
	    + " 2. ERLANGA (a, b>0)\n"
	    + " 3. GAMMA (a,b>0; a<1)\n"
	    + " 4. WYKLADNICZY (a>0)\n";
    
    public static String GENERATOR_ZAKRES = "" + "--------------------------------\n"
	    + "WYBIERZ ZAKRES (np. 10) ";



}
