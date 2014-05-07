package app.run.test;

import pl.edu.wat.wcy.tal.aproximate.KarmarkarKarp;
import pl.edu.wat.wcy.tal.data.Generator;

public class Test {
	
	private KarmarkarKarp KK;
	private Generator generator;
	private String PATH = "C:\\Users\\Łukasz\\Desktop\\data.txt";
	
	public Test() {
		KK = new KarmarkarKarp();
		generator = new Generator();
	}
	
	public void rt() {
		int [] arr = generator.generateRandomData(7, 10);
		KK.karmarkarKarpExpand(arr);
		generator.getDataFromFile(PATH);
	}
	
	
	public static void main(String[] args) {
		//int [] arr = {3,6,13,20,30,40,73};
//		int [] arr = {1,2,3,4,5,9,1,1,2,3,1};
		//int [] arr = {4,5,6,7,8};
		//System.out.println(algorytm.karmarkarKarp(arr));
		Test t = new Test();
		t.rt();
	}

}
