package pl.edu.wat.wcy.tal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void menu() {
	String input = "";
	while (!input.contains("2")) {
	    Console.print(Messages.MENU);
	    input = Console.getInput();
	    if (input.contains("1")) {
		run();
	    } else if (input.contains("2")){
		print(Messages.KONIEC);
	    } else {
		print(Messages.WARNING);
	    }
	}
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
    
    public static void run() {
	int zakres = generatorZakres();
	double[] parametry = generatorRozklad();
	for (int i=4; i<zakres; i++) {
	    Application.run(Generator.generate(i, parametry));
	    i++;
	}
	
    }
}
