package pl.edu.wat.wcy.tal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pl.edu.wat.wcy.tal.Counter;
import pl.edu.wat.wcy.tal.data.Generator;
import app.run.test.Application;
import app.run.test.Messages;

public class Console {

    static BufferedReader br = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void clear(int n) {
	for (int i = 0; i < n; i++) {
	    System.out.println("\n");
	}
    }

    public static String getInput() {
	String input = "";
	try {
	    input = br.readLine();
	} catch (IOException e) {
	    Console.print(Messages.BLAD_ODCZYTU);
	}
	return input;
    }

    public static void print(String string) {
	System.out.println(string);
    }

    public static void welcome() {
	Console.print(Messages.WELCOME);
	Console.getInput();
	Console.clear(10);
    }

    private static int generatorZakres() {
	Console.print(Messages.GENERATOR_ZAKRES);
	int zakres = 0;
	try {
	    zakres = Integer.parseInt(Console.getInput());
	} catch (Exception e) {
	    Console.print(Messages.WARNING);
	}
	return zakres;
    }

    private static double[] generatorRozklad() {
	Console.print(Messages.GENERATOR_ROZKLAD);
	int rozklad = 0;
	double[] parametry = new double[3];
	try {
	    rozklad = Integer.parseInt(Console.getInput());
	    FileUtilHelper.getInstane().setRozklad(rozklad);
	    parametry[0] = rozklad;
	    if (rozklad != 4) {
		Console.print(Messages.PARAMETR_A);
		parametry[1] = Double.parseDouble(Console.getInput());
		Console.print(Messages.PARAMETR_B);
		parametry[2] = Double.parseDouble(Console.getInput());
	    } else {
		Console.print(Messages.PARAMETR_A);
		parametry[1] = Double.parseDouble(Console.getInput());
		parametry[2] = 0;
	    }
	} catch (Exception e) {
	    Console.print(Messages.WARNING);
	}
	return parametry;
    }

    public static void run(int mode, boolean isSeries) {
	int zakres = generatorZakres();
	double[] parametry = generatorRozklad();
	int start = encodeMode(mode, isSeries, zakres);
	for (int i = start; i <= zakres; i++) {
	    Application.run(Generator.generate(i, parametry), mode);
	    pierwszy(true);
	}
	printScores(mode);
    }

    public static int encodeMode(int mode, boolean isSeries, int range) {
	if (mode == 1 || (isSeries && mode > 1 && mode <= 4)) {
	    return 2; // seria dla wszystkich, lub seria dla wybranego algorytmu
	} else if (!isSeries && mode > 1 && mode <= 4) {
	    return range; // wybrany algorytm bez serii
	}
	return -1;
    }

    public static int menu() {
	String input = "";
	while (!input.contains("4")) {
	    print(Messages.MODE);
	    input = Console.getInput();
	    if (input.contains("1")) {
		seria(true, true);
		run(1, true);
	    } else if (input.contains("2a")) {
		seria(true, false);
		run(2, true);
	    } else if (input.contains("2b")) {
		seria(true, false);
		run(3, true);
	    } else if (input.contains("2c")) {
		seria(true, false);
		run(4, true);
	    } else if (input.contains("3a")) {
		seria(false, false);
		run(2, false);
	    } else if (input.contains("3b")) {
		seria(false, false);
		run(3, false);
	    } else if (input.contains("3c")) {
		seria(false, false);
		run(4, false);
	    } else if (input.contains("4")) {
		print(Messages.KONIEC);
		return 0;
	    } else {
		print(Messages.WARNING);
	    }
	}
	return 0;
    }
    
    private static void seria(boolean s, boolean sAll) {
	FileUtilHelper.getInstane().setSeria(s);
	FileUtilHelper.getInstane().setSeriaAll(sAll);
    }
    
    private static void pierwszy (boolean p) {
	FileUtilHelper.getInstane().setPierwszy(p);
    }

    public static void printScores(int mode) {
	print(Messages.WYNIK);
	if (mode == 1) {
	    print(Messages.ALG_BRUTE_FORCE + Counter.getInstance().getBF()
		    + Messages.MIKRO);
	    print(Messages.ALG_DYNAMICZNY + Counter.getInstance().getDC()
		    + Messages.MIKRO);
	    print(Messages.ALG_KK + Counter.getInstance().getKK()
		    + Messages.MIKRO);
	    long diff = Counter.getInstance().getBF()
		    - Counter.getInstance().getKK();
	    long procent = diff / Counter.getInstance().getKK();
	    procent = procent * 100;
	    print(Messages.DIFF + diff);
	    print(Messages.PROCENTOWO + procent + Messages.PROPORCJA);
	} else if (mode == 2) {
	    print(Messages.ALG_BRUTE_FORCE + Counter.getInstance().getBF()
		    + Messages.MIKRO);
	} else if (mode == 3) {
	    print(Messages.ALG_DYNAMICZNY + Counter.getInstance().getDC()
		    + Messages.MIKRO);
	} else if (mode == 4) {
	    print(Messages.ALG_KK + Counter.getInstance().getKK()
		    + Messages.MIKRO);
	}

	Counter.setDefault();
    }
}
