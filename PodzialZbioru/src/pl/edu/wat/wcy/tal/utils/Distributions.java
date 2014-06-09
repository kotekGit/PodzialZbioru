package pl.edu.wat.wcy.tal.utils;

import java.util.Random;

public class Distributions extends Random{
    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    Integer n;

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public double raw() {
	return this.nextInt(this.n);
    }

    public int uniform(double a, double b) {
	if (b < a) {
	    System.err.println("SimGenerator.uniform: give b>a");
	    return (-1);
	}
	double d = (raw() * (b - a) + a);
	return (int) d;
    }

    public double exponential(double a) {
	if (a < 0) {
	    System.err.println("SimGenerator.exponential: a must be >0");
	    return (-1);
	}
	return (a * (-Math.log((raw()))));
    }

    public double erlang(int n, double a) {
	if (a < 0) {
	    System.err.println("SimGenerator.laplace: give a>0");
	    return (-1);
	} else {
	    return (gamma((double) n, a));
	}
    }

    public double gamma(double a, double b) {
	double xx, avg, am, e, s, v1, v2, yy;
	if ((a < 0.0) || (b < 0.0))
	    System.err.println("SimGenerator.gamma: a and b be >0 and a<=1");

	if (a < 1.0) {
	    do {
		xx = Math.pow(raw(), 1.0 / a);
		yy = Math.pow(raw(), 1.0 / (1.0 - a));
	    } while (xx + yy > 1.0);

	    xx = xx / (xx + yy);
	    yy = exponential(1);
	    return xx * yy / b;
	}

	if (a == 1.0)
	    return (exponential(1) / b);

	do {
	    do {
		do {
		    v1 = 2.0 * raw() - 1.0;
		    v2 = 2.0 * raw() - 1.0;
		} while (v1 * v1 + v2 * v2 > 1.0);

		yy = v2 / v1;
		am = a - 1.0;
		s = Math.sqrt(2.0 * am + 1.0);
		avg = s * yy + am;
	    } while (avg <= 0.0);
	    e = (1.0 + yy * yy) * Math.exp(am * Math.log(avg / am) - s * yy);
	} while (raw() > e);

	return avg / b;
    }


}
