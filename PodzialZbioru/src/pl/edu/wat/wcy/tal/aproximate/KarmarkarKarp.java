package pl.edu.wat.wcy.tal.aproximate;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import pl.edu.wat.wcy.tal.utils.StructureConverter;

public class KarmarkarKarp {

	/**
	 * Implementacja algorytmu Karmarkar'a Karpa.
	 * 
	 * @param arr
	 *            Tablica elementów zbioru do podziału.
	 * @author Łukasz Kotowski
	 * @return int Różnica pomiędzy wartościami dwóch zbiorów powstałych w
	 *         wyniku podziału.
	 */
	public int karmarkarKarp(int[] arr) {
		PriorityQueue<Integer> S = StructureConverter.arrayToPriorityQueue(arr);
		while (S.size() > 1) {
			int a = S.poll();
			int b = S.poll();
			S.add(a - b);
		}
		return S.poll();
	}

	/**
	 * Rozszerzona implementacja algorytmu Karmarkar'a Karpa. Oprócz
	 * standardowego podziału zbioru i zwrócenia rónicy pomiędzy powstalymi
	 * podzbiorami, przypisuje dodatkowo każdy z elementów zbioru pierwotnego do
	 * jednego z nowopowstałych podzbiorów i wyprowadza wynik użytkownikowi.
	 * 
	 * @param arr
	 *            Tablica elementów zbioru do podziału.
	 * @author Łukasz Kotowski
	 * @return int - Rónica pomiędzy wartościami dwóch zbiorów powstałych w
	 *         wyniku podziału.
	 */
	public int karmarkarKarpExpand(int[] arr) {
		PriorityQueue<Integer> S = StructureConverter.arrayToPriorityQueue(arr);
		List<Integer> _a = new LinkedList<Integer>();
		List<Integer> _b = new LinkedList<Integer>();
		List<Integer> aMinusB = new LinkedList<Integer>();

		while (S.size() > 1) {
			int a = S.poll();
			int b = S.poll();
			S.add(a - b);
			_a.add(a);
			_b.add(b);
			aMinusB.add(a - b);
		}
		List<Integer> A = new LinkedList<Integer>();
		List<Integer> B = new LinkedList<Integer>();
		List<Integer> aPrim = new LinkedList<Integer>();
		aPrim.add(S.peek());
		for (int i = _a.size() - 1; i >= 0; i--) {
			int x = aMinusB.get(i);
			int tmp = aPrim.indexOf(x);
			if (tmp >= 0) {
				System.out.println("Usuwam " + x + ", aPrim idx " + tmp);
				aPrim.remove(tmp);
			}
			int a = _a.get(i);
			aPrim.add(a);
			System.out.println("Dodaje do A " + a);
			A = aPrim;
			int b = _b.get(i);
			if (b != 0) {
				B.add(b);
				System.out.println("Dodaje do B " + b + "\n\n");
			}

		}
		System.out.println(A);
		System.out.println(B);
		return S.poll();
	}
}
