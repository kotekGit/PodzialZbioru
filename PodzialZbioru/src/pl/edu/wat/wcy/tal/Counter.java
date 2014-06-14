package pl.edu.wat.wcy.tal;


public final class Counter {
    
    private final static Counter instance = new Counter();
    private Long KK = 0L;
    private Long BF = 0L;
    private Long DC = 0L;
    
    
    public void addKK(Long actual) {
	KK = getKK() + actual;
    }
    
    public void addBF(Long actual) {
	BF = getBF() + actual;
    }
    
    public void addDC(Long actual) {
	DC = getDC() + actual;
    }
    
    public Long getKK() {
        return KK;
    }

    public void setKK(Long kK) {
        KK = kK;
    }

    public Long getBF() {
        return BF;
    }

    public void setBF(Long bF) {
        BF = bF;
    }

    public Long getDC() {
        return DC;
    }

    public void setDC(Long dC) {
        DC = dC;
    }

    private Counter() {}

    public static Counter getInstance() {
	return instance;
    }
    
    public static void setDefault() {
	Counter.getInstance().setBF(0L);
	Counter.getInstance().setDC(0L);
	Counter.getInstance().setKK(0L);
    }
    

}
