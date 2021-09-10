package pack.main2;

import java.util.Scanner;
import java.util.regex.Pattern;

import pack.main.*;

public class Controller2  {
    private Model2 M;
    
    public Controller2() {
    	this(new Model2());
    }
    public Controller2(Model2 model2) {
    	this.M = model2;
    }
    
    public void processUser() throws UnicityException{  
		Scanner sc = new Scanner(System.in);
		View.println(View.bundleString("output.greeting"));
		M.addToSet(new Model(processInput(sc)));
		M.addToSet(new Model(processInput(sc)));
    }
            
    public String processInput(Scanner sc) throws UnicityException {
		String input = null;
		String pattern = View.bundleString("regex.login.data");		
		View.concatAndPrint(View.bundleString("input.string.data","input.login.data"));	
		input = processUnicity(sc);
		
		while(!Pattern.matches(pattern, input)) {	
			View.println(View.bundleString("input.wrong.data"));
			input = processUnicity(sc);
		}
		return input;		
	}
    
    public String processUnicity(Scanner sc) throws UnicityException {
    	String input = sc.nextLine();
    	try {			
			if(!M.isAuthentic(input)) throw new UnicityException();				
		} catch ( UnicityException e ){
			input = View.tab;
		}
		return input;    	
    }
}