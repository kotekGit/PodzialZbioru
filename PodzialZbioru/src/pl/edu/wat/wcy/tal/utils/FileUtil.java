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

    private static final String PATH = "C:\\Users\\Łukasz\\Desktop\\TAL.csv";

    public static void saveTime(Long time, String description) {
	try (PrintWriter out = new PrintWriter(new BufferedWriter(
		new FileWriter(PATH, true)))) {
	    out.flush();
	    String rozklad = FileUtilHelper.getInstane().getRozklad();
	    if (FileUtilHelper.getInstane().isSeria()) {
		if (FileUtilHelper.getInstane().isPierwszy()) {
		    String t = "";
		    if (FileUtilHelper.getInstane().isSeriaAll()) {
			t = "\nSeria {(BF, DC, KK), ("+rozklad+")}: " + time;
		    } else {
			t = "\nSeria {(" + description + "), (" +rozklad+")}: " + time;
		    }
		    out.print(t + ";");
		    FileUtilHelper.getInstane().setPierwszy(false);
		} else {
		    out.print(" "+time+";");
		}
	    } else {
		String t = "\n{(" + description + "),("+rozklad+")}: " + time;
		out.println(t + ";");
		FileUtilHelper.getInstane().setPierwszy(true);
	    }

	} catch (IOException e) {
	    Console.print("Nie udało się zapisać wyniku do pliku!");
	}
    }

}
