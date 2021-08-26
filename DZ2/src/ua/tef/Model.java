package ua.tef;

public class Model {
	public final static int DEF_MIN = 0;
	public final static int DEF_MAX = 100;
	
    private int minBound;
    private int maxBound;
    private int answer;
    private String statistics = "\nВаша статистика:";
    private int count = 0;
    
    public Model(int min, int max) {
    	this.minBound = min;
    	this.maxBound = max;
    	this.answer = minBound + (int) Math.round(Math.random() * (maxBound - minBound));
    }
    
    public Model() {
    	this(DEF_MIN, DEF_MAX);
    }
   
    public void setMin(int min) {
    	minBound = min;
    }
    
    public void setMax(int max) {
    	maxBound = max;
    }
    
    public int getMin() {
    	return this.minBound;
    }
    
    public int getMax() {
    	return this.maxBound;
    }
    
    public int getAnswer() {
    	return this.answer;
    }
    public String getStats() {
    	return this.statistics;
    }
    
    public void addToStats(String str) {
    	this.statistics += str;
    }
    
    public void incrementCount() {
    	this.count++;
    }
    
    public int getCount() {
    	return this.count;
    }
 
}