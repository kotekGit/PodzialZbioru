package pl.edu.wat.wcy.tal.exact;

import java.util.Date;
import java.util.logging.Logger;

import pl.edu.wat.wcy.tal.Counter;
import pl.edu.wat.wcy.tal.utils.Array;
import pl.edu.wat.wcy.tal.utils.FileUtil;

public class DynamicAlgorithm {
    private static Logger log = Logger.getLogger(DynamicAlgorithm.class
	    .getName());

    private int[] lastArray;
    private int lastSum;
    private boolean existEqualPartitions;
    private Permutation lastPermutation = null;
    private Date startTime;
    private Date finishTime;
    private long start;
    private long stop;

    /**
     * @author Mariusz Kielan
     */
    public boolean solve(int[] array) {
	startTime = new Date();
	start = System.nanoTime();
	int n = array.length;
	int i, j;
	int sum = Array.sum(array);
	int L = sum / 2;

	if (sum % 2 != 0)
	    return false;

	// zainicjowanie tablicy
	boolean[][] part = new boolean[n][L + 1];

	for (j = 0; j <= L; j++)
	    part[0][j] = j == 0 || j == array[0];

	for (i = 1; i < n; i++) {
	    for (j = 0; j <= L; j++) {
		part[i][j] = part[i - 1][j]
			|| (array[i] <= j && part[i - 1][j - array[i]]);
	    }
	}
	stop = System.nanoTime();
	finishTime = new Date();
	lastSum = sum;
	lastArray = array;
	existEqualPartitions = part[n - 1][L];

	return part[n - 1][L];
    }

    public void print() {
	StringBuilder sb = new StringBuilder();

	if (lastPermutation != null) {
	    sb.append("Wykonano podzial zbioru algorytmem Brute Force");

	    sb.append("Data rozpoczęcia: " + startTime + "\n");
	    sb.append("Data zakończenia: " + finishTime + "\n");
	    sb.append("Czas trwania: "
		    + (startTime.getTime() - finishTime.getTime()) + "[ms]\n");
	    sb.append("Tablica wejsciowa: " + Array.toString(lastArray));
	    sb.append("A = " + Array.toString(lastPermutation.firstArray()));
	    sb.append("B = " + Array.toString(lastPermutation.secondArray()));
	    sb.append("Suma wszystkich elementow: " + lastSum + "\n");

	    if (existEqualPartitions)
		sb.append("Nie udalo sie rozwiazac problemu!\n");
	    else
		sb.append("Wyznaczono rowne zbiory!\n");
	} else {
	    sb.append("Nie obliczano jeszcze zadnego problemu\n");
	    ;
	}

	log.info(sb.toString());
    }

    public void saveTime() {
	long time = stop - start;
	time = time / 1000;
	Counter.getInstance().addDC(time);
	FileUtil.saveTime(time, "DC");
    }
}
