package pl.edu.wat.wcy.tal.utils;

public class Distribution {

    static Distributions d = new Distributions();

    public static int getRandom(int distribution, double a, double b, int size) {
	d.setN(size);
	if (distribution == 1) {
	    return d.uniform(a, b) % size;
	} else if (distribution == 2) {
	    int n = (int) a;
	    return (int) d.erlang(n, b) % size;
	} else if (distribution == 3) {
	    return (int) d.gamma(a, b) % size;
	} else if (distribution == 4) {
	    return (int) d.exponential(a) % size;
	}
	return 0;

    }

}
