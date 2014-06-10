/**
 * Łukasz Kotowski
 */
package pl.edu.wat.wcy.tal.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Łukasz Kotowski
 *
 */
public class FileUtil {
    
    public static void saveTime(Long time, String fileName) {
	try (PrintWriter out = new PrintWriter(new BufferedWriter(
		new FileWriter(fileName + ".csv", true)))) {
	    out.flush();
	    String t = ""+time;
	    out.print(t + ";");

	} catch (IOException e) {
	    Console.print("Nie udało się zapisać wyniku do pliku!");
	}
    }

}
