package app.run.test;

/**
 * Klasa testowa aplikacji.
 * 
 * @author Łukasz Kotowski
 * 
 */
public class Test {

	/**
	 * Uruchamia test aplikacji.
	 */
	public void runTest() {
		new Application();
	}

	/**
	 * Metoda statyczna main. 
	 * @param args argumenty metody.
	 */
	public static void main(String[] args) {
		Test t = new Test();
		t.runTest();
	}

}
