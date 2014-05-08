package pl.edu.wat.wcy.tal;

/** 
 * Interfejs rozwiązujący problem podziału  w wersji optymalizacyjnej
 * 
 * @author Mariusz Kielan 
 * 
 */
public interface IOptPartition {
	
	/**
	 * 
	 * @param array - tablica elementów zbioru do podziału
	 * @return int - najmniejsza możliwa odległość między dwoma powstałymi w wyniku podziału zbiorami
	 */
	int partition(int[] array);
}
