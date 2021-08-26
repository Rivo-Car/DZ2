package ua.tef;

import java.util.Scanner;

public class Controller {
	private Model model;
	private Scanner sc = new Scanner(System.in); 
    
    public Controller() {
    	View.printMessage(View.GREETING);
        String insert = sc.nextLine();
        int minimum = 1;
        int maximum = 0;
    	if (insert.equals("x")) {

    		while(minimum > maximum) {
    		    View.printMessage(View.INPUT_MIN);
    		    minimum = sc.nextInt();
    		    View.printMessage(View.INPUT_MAX);
    		    maximum = sc.nextInt();
    		}
    		View.println("");  	           	   
    	    this.model = new Model(minimum, maximum);   		
    	}
    	else this.model  = new Model();       
    }

    // The Work method
    public void processUser(){   
    	controlInput(sc);
    	printAndAddToStats("\n", View.RIGHT_INPUT + model.getAnswer());  
    	View.println("");
    	model.addToStats("\n" + View.COUNT + model.getCount());
    	View.println(model.getStats());
    }
    
    private void controlInput(Scanner sc) {
    	int yourAnswer = inputIntWithScanner(sc);
    	while(model.getAnswer() != yourAnswer) { 
    		model.incrementCount();
    		
    		if((yourAnswer <= model.getMax()) && (yourAnswer >= model.getMin())) {
    			
    			View.println(View.WRONG_INPUT);
                
    			printAndAddToStats("\n", View.YOUR_INT + yourAnswer + "! "
        	            + View.CONSOLE_ANSWER);
    			
    			if (model.getAnswer() > yourAnswer) {
    			    printAndAddToStats("", View.MORE_OR_LESS[1]); 
    			    model.setMin(yourAnswer + 1);
    		    } else {
    			    printAndAddToStats("", View.MORE_OR_LESS[0]);
    			    model.setMax(yourAnswer - 1);
    		    }
    		} else {
    			printAndAddToStats("\n", View.ERROR_INPUT);    			
    		}
    		yourAnswer = inputIntWithScanner(sc);    	    		
    	}    	    	
    }

    private int inputIntWithScanner(Scanner sc) {
        View.printMessageAndBoundaries(View.INPUT_INT_DATA, model.getMin(), model.getMax());
        return sc.nextInt();
    }
    
    private void printAndAddToStats(String format, String strToAdd) {
    	View.printMessage(strToAdd);
    	model.addToStats(format + strToAdd);
    }
}