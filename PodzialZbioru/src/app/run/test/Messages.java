package app.run.test;

/**
 * Klasa przechowująca wiadomości wyświetlane użytkownikowi.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class Messages {

    
    public static String WELCOME = "--------------------------------\n"
	    + "WOJSKOWA AKADEMIA TECHNICZNA\n"
	    + "TECHNIKI ALGORYTMICZNE\n"
	    + "PROBLEM PODZIALU ZBIORU\n"
	    + "ALGORYTMY:\n"
	    + " - Brute Force, \n - Programowania Dynamicznego,\n"
	    + " - Karmarkara Karpa'a.\n"
	    + "PROWADZACY: mgr inz. Tomasz DROZDOWSKI\n"
	    + "WYKONALI: Mariusz KIELAN, Lukasz KOTOWSKI";
    
/*    public static String MENU = "--------------------------------\n"
	    + "MENU GLOWNE:\n" + " 1 - algorytm dokładny (brute force)\n"
	    + " 2 - algorytm dokładny (programowanie dynamiczne)\n"
	    + " 3 - algorytm aproksymacyjny\n" + " @ - aby zakończyć\n"
	    + "--------------------------------\n" + "Twój wybór: ";*/
    
    public static String MENU = "" + "--------------------------------\n"
	    + "MENU\n"
	    + " 1. Generator\n"
	    + " 2. Koniec\n";

    public static String GENERATOR_ROZKLAD = "" + "--------------------------------\n"
	    + "WYBIERZ ROZKLAD:\n"
	    + " 1. UNIFORM (b>a)\n"
	    + " 2. ERLANG (a, b>0)\n"
	    + " 3. GAMMA (a,b>0; a<1)\n"
	    + " 4. EXPONENTIAL (a>0)\n";
    
    public static String GENERATOR_ZAKRES = "" + "--------------------------------\n"
	    + "WYBIERZ ZAKRES (np. 10) ";

    public static String KONIEC = "Poprawnie zakonczono dzialanie programu.";
    public static String ALG_DOKLADNY = "algorytm dokladny";
    public static String ALG_APROKSYMACYJNY = "algorytm aproksymacyjny - KK";
    public static String ALG_BRUTE_FORCE = "algorytm brute force";
    public static String ALG_DYNAMICZNY = "algorytm dynamiczny";
    public static String GEN_LOS = "generator losowy";
    public static String GEN_Z_PLIKU = "dane z pliku";
    public static String WARNING = "Nieprawidlowa wartosc!";
    public static String WPROWADZ_ZAKRES = "Zakres: ";
    public static String WPROWADZ_ILOSC = "Ilosc elementow: ";
    public static String BLAD_ODCZYTU = "Blad odczytu strumienia wejsciowego!";
    public static String PARAMETR_A = "Podaj parametr a: ";
    public static String PARAMETR_B = "Podaj parametr b: ";

}
