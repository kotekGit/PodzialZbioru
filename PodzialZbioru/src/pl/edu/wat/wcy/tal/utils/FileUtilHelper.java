package pl.edu.wat.wcy.tal.utils;

public class FileUtilHelper {
    
    private final static FileUtilHelper instance = new FileUtilHelper();
    
    private boolean seria;
    private boolean seriaAll;
    private boolean pierwszy;
    private String rozklad;
    
    private FileUtilHelper() {
	seria = false;
	pierwszy = true;
	seriaAll = false;
	rozklad = "";
    }

    public static FileUtilHelper getInstane() {
	return instance;
    }

    public boolean isSeria() {
	return seria;
    }

    public void setSeria(boolean seria) {
	this.seria = seria;
    }

    public boolean isPierwszy() {
	return pierwszy;
    }

    public void setPierwszy(boolean pierwszy) {
	this.pierwszy = pierwszy;
    }

    public boolean isSeriaAll() {
	return seriaAll;
    }

    public void setSeriaAll(boolean seriaAll) {
	this.seriaAll = seriaAll;
    }

    public String getRozklad() {
	return rozklad;
    }

    public void setRozklad(int r) {
	if (r == 1) this.rozklad = "JEDNOSTAJNY";
	if (r == 2) this.rozklad = "ERLANGA";
	if (r == 3) this.rozklad = "GAMMA";
	if (r == 4) this.rozklad = "WYKLADNICZY";
    }
    
    

}
