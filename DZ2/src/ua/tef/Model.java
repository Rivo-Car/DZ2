package ua.tef;

public class Model {
	public final static int DEF_MIN = 0;
	public final static int DEF_MAX = 100;
	
    private int minBound;
    private int maxBound;
    private int answer;
    private String statistics;
    private int count;
    
    public Model(int min, int max) {
    	this.minBound = min;
    	this.maxBound = max;
    	this.answer = minBound + (int) Math.round(0.5 + Math.random() * (maxBound - minBound - 1));
    	this.statistics = "\nВаша статистика:";
    	this.count = 0;
    }
    
    public Model() {
    	this(DEF_MIN, DEF_MAX);
    }
    
    public String getStats() {
    	return this.statistics;
    }
    
    public int getAnswer ( ) {return answer;}
    
    public void addToStats(String str) {
    	this.statistics += str;
    }
    
    public void incrementCount() {
    	++this.count;
    }
    
    public int getCount() {
    	return this.count;
    }
    
    public boolean equalsToSolution(int guess) {
    	return guess == this.answer;
    }
    
    public String answerToConsole(String str) {
    	return str + answer;
    }
    
    public int compareToSolutionAndChangeBounds(int guess) {   	
    	int i = guess > this.answer ? 0 : 1;
    	this.minBound += i * (guess - this.minBound);
    	this.maxBound -= (1 - i) * (this.maxBound - guess);
    	return i;
    }
    
    public boolean isInBounds(int guess) {
    	return guess <= this.maxBound && guess >= this.minBound;
    }
    
    public String StringToBounds(String str) {
    	return str + "[" + this.minBound + "," + this.maxBound + "]: ";
    } 
}
