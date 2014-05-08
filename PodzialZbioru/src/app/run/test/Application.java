package app.run.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.edu.wat.wcy.tal.aproximate.Graph;
import pl.edu.wat.wcy.tal.aproximate.KarmarkarKarp;
import pl.edu.wat.wcy.tal.data.Generator;

public class Application {
	private KarmarkarKarp KK;
	private Generator generator;
	private String PATH = "C:\\Users\\Łukasz\\Desktop\\data.txt";
	private static Logger log = Logger.getLogger("Application");
	
	public Application() {
		KK = new KarmarkarKarp();
		generator = new Generator();
		init();
	}
	
	private void init() {
		log.log(Level.INFO, "Uruchomiono aplikację.");
		String input = "a";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!input.contains("@")) {
			System.out.println(Messages.MENU);
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (input.contains("1")) {
				log.log(Level.INFO, "Wybrano "+Messages.ALG_DOKLADNY);
			} else if (input.contains("2")) {
				log.log(Level.INFO, "Wybrano "+Messages.ALG_APROKSYMACYJNY);
			} else if (input.contains("@")){
				log.log(Level.INFO, Messages.KONIEC);
			} else {
				log.log(Level.WARNING, "Nieprawidłowa wartość! ");
			}
		}
	}
	
	public void v() {
		int [] arr = {73,40,30,20,13,6,3};//generator.generateRandomData(7, 10);
		//KK.karmarkarKarpExpand(arr);
		//generator.getDataFromFile(PATH);
	}

}
