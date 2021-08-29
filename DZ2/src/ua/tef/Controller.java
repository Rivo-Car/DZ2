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
    	printAndAddToStats("\n", model.answerToConsole(View.RIGHT_INPUT));  
    	View.println("");
    	model.addToStats("\n" + View.COUNT + model.getCount());
    	View.println(model.getStats());
    }
    
    private void controlInput(Scanner sc) {
    	int yourAnswer = inputIntWithScanner(sc);
    	
    	while(!model.equalsToSolution(yourAnswer)) { 
    		model.incrementCount();
    		printAndAddToStats("\n", View.YOUR_INT + yourAnswer
    	            + View.CONSOLE_ANSWER);
    		
    		if(model.isInBounds(yourAnswer)) {   			
    			View.println(View.WRONG_INPUT);
                int index = model.compareToSolutionAndChangeBounds(yourAnswer);  
                printAndAddToStats("", View.MORE_OR_LESS[index]);
    		} else {
    			printAndAddToStats("", View.ERROR_INPUT);    			
    		}
    		yourAnswer = inputIntWithScanner(sc);    	    		
    	}    	    	
    }

    private int inputIntWithScanner(Scanner sc) {
        View.printMessage(model.StringToBounds(View.INPUT_INT_DATA));
        return sc.nextInt();
    }
    
    private void printAndAddToStats(String format, String strToAdd) {
    	View.printMessage(strToAdd);
    	model.addToStats(format + strToAdd);
    }
}