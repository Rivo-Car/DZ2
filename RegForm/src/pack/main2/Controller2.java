package pack.main2;

import java.util.Scanner;
import java.util.regex.Pattern;

import pack.main.Fields;
import pack.main.View;

public class Controller2 {
    private Model2 M;
    
    public Controller2(Model2 model2) {
    	this.M = model2;
    }
    
    public void processUser(){  
		Scanner sc = new Scanner(System.in);
		View.println(View.bundleString("output.greeting"));
		
    }
    
    public void processInput(Scanner sc, Fields field) {
		String input = null;
		String pattern = View.bundleString("regex.login.data");		
		View.concatAndPrint(View.bundleString("input.string.data","input.login.data"));	
		input = sc.nextLine();
		
		while(!Pattern.matches(pattern, input)) {	
			View.println(View.bundleString("input.wrong.data"));
			input = sc.nextLine();
		}
	}
}