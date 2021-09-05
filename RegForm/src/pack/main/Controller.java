package pack.main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller{
	Model model;
	View view; 
	String locale;
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.locale = View.bundle.getLocale().toString();
	}
	
	public void processUser(){  
		Scanner sc = new Scanner(System.in);
		View.println(View.bundleString("output.greeting"));		
//    	processInput(sc, "regex.first.name.data", Fields.First_name, 
//    			"input.string.data","input.first.name.data");
//    	processInput(sc, "regex.surname.data", Fields.Surname,
//    			"input.string.data","input.surname.data");
//    	processInput(sc, "regex.first.name.data", Fields.Patronymic,
//    			"input.string.data","input.patr.data");
//    	model.FIO();
//    	processInput(sc, "regex.login.data", Fields.Login,
//    			"input.string.data","input.login.data");
    	processInputGroup(sc);
//    	processInput(sc, "regex.home.number.data", Fields.Home_Phone,
//    			"input.string.data","input.home.number.data");
//    	processInput(sc, "regex.first.mobile.number.data", Fields.Mobile_Phone,
//    			"input.string.data","input.first.mobile.number.data");
//    	processInput(sc, "regex.second.mobile.number.data", Fields.Mobile_Phone_2,
//    			"input.string.data","input.second.mobile.number.data");
//    	processInput(sc, "regex.email.data", Fields.Email,
//    			"input.string.data","input.email.data");
//		processInput(sc, "regex.skype.data", Fields.Skype,
//				"input.string.data","input.skype.data");
//		processInput(sc, "regex.address.data", Fields.Address,
//				"input.string.data","input.address.data");
		model.WriteToUserData(Fields.Date_of_Creation, java.time.LocalDate.now().toString());
		model.WriteToUserData(Fields.This_day, java.time.LocalDate.now().toString());
    	View.println("");
    	
    	for(String k: model.returnDatas(locale)) {
    		View.println(k);
    	}	
	}
		
	public void processInput(Scanner sc, String regex, Fields field, String... inputKeys) {
		String input = null;
		String pattern = View.bundleString(regex);		
		View.concatAndPrint(View.bundleString(inputKeys));	
		input = sc.nextLine();
		
		while(!Pattern.matches(pattern, input)) {	
			View.println(View.bundleString("input.wrong.data"));
			input = sc.nextLine();
		}
		model.WriteToUserData(field, input);
	}
	
	public void processInputGroup(Scanner sc) {
		View.concatAndPrint(View.bundleString("input.string.data","input.group.data"));
        String input = sc.nextLine();
        String[] GroupArray = locale.equals("en") ? Model.Groups : Model.Gruppy;
        
		while(! Arrays.stream(GroupArray).anyMatch(input::equals)) {	
		    View.printMessage(View.bundleString("input.wrong.data"));
	        input = sc.nextLine();
	   }
	    model.WriteToUserData(Fields.Group, input);
    }	
}