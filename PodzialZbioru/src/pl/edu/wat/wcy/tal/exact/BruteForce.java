package pl.edu.wat.wcy.tal.exact;

import java.util.Date;
import java.util.logging.Logger;

import pl.edu.wat.wcy.tal.Counter;
import pl.edu.wat.wcy.tal.IPartition;
import pl.edu.wat.wcy.tal.utils.Array;
import pl.edu.wat.wcy.tal.utils.FileUtil;

/**
 * Rozwiązywanie problemu podziału zbioru algorytmem brute force.
 * 
 * @author Mariusz Kielan
 */
public class BruteForce implements IPartition {	
	private static Logger log = Logger.getLogger(BruteForce.class.getName());
	
	private int[] lastArray;
	private int lastSum;
	private boolean existEqualPartitions;
	private int distance;
	private Permutation lastPermutation = null;
	private Date startTime;
	private Date finishTime;
	private long start;
	private long stop;
	
	@Override
	public int solve(int[] array) {
		startTime = new Date();
		start = System.nanoTime();
		int totalSum = Array.sum(array);
		
		Permutation permutation = new Permutation(array);
		int sum = totalSum;
		
		while(permutation.existNextSymetricPermutation()) {
			permutation.next();
			
			if(permutation.sum() == totalSum / 2.) {
			    sum = permutation.sum();
			    break;
			}
			
			if(
				Math.abs(totalSum/2. - sum)
				>
				Math.abs(totalSum/2. - permutation.sum()) 
			)
				sum = permutation.sum();
		}
		stop = System.nanoTime();
		finishTime = new Date();
		lastSum = sum;
		lastArray =  array;
		distance = Math.abs(totalSum - 2*sum);
		existEqualPartitions = distance == 0;
		lastPermutation = permutation;
		
		return distance;
	}

	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		
		if(lastPermutation != null) {
			sb.append("Wykonano podzial zbioru algorytmem Brute Force");
			
			sb.append("Data rozpoczęcia: "+ startTime +"\n");
			sb.append("Data zakończenia: "+ finishTime +"\n");
			sb.append("Czas trwania: " + (startTime.getTime() - finishTime.getTime()) + "[ms]\n");
			sb.append("Tablica wejsciowa: " + Array.toString(lastArray));
			sb.append("A = " + Array.toString(lastPermutation.firstArray()));
			sb.append("B = " + Array.toString(lastPermutation.secondArray()));
			sb.append("Suma wszystkich elementow: " + lastSum + "\n");
			if(existEqualPartitions) sb.append("Odleglosc miedzy wyznaczonymi zbiorami: " + distance + "\n");
			else sb.append("Wyznaczono równe zbiory!\n");
		}
		else {
			sb.append("Nie obliczano jeszcze zadnego problemu\n");;
		}
		
		log.info(sb.toString());
	}
	
	    public void saveTime() {
		long time = stop - start;
		time = time / 1000;
		Counter.getInstance().addBF(time);
		FileUtil.saveTime(time, "BF");
	    }
}
