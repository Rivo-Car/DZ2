package pack.main;
import java.util.*;
import java.util.regex.Pattern;

public class Model {
	public final static String[] Groups = {"FI-11", "FI-12", "FI-13", "FI-14"};
	public final static String[] Gruppy = {"ФІ-11", "ФІ-12", "ФІ-13", "ФІ-14"};
    private HashMap<Fields, String> regDatas;
    
    public Model() {
    	regDatas = new HashMap<Fields, String>();
    	this.WriteToUserData(Fields.Date_of_Creation, java.time.LocalDate.now().toString());
		this.WriteToUserData(Fields.This_day, java.time.LocalDate.now().toString());
    }

    private void WriteToUserData(Fields field, String Data) {
    	regDatas.put(field, Data);
    }
    
    public String FIO() {
    	String FIO = "";
    	FIO += regDatas.get(Fields.Surname) + " ";
    	FIO += regDatas.get(Fields.First_name).substring(0, 1) + ".";
    	FIO += regDatas.get(Fields.Patronymic).substring(0, 1) + ".";
    	this.WriteToUserData(Fields.FIO, FIO);
    	return FIO;   	
    }
    
    public boolean matches(String input, String pattern, Fields field) {
    	boolean result = Pattern.matches(pattern, input);
    	
    	if (result) {
    		this.WriteToUserData(field, input);
    	}
    	return result;
    }
    
    public boolean matches(String input, String[] ArrayString) {
    	boolean result =  Arrays.stream(ArrayString).anyMatch(input::equals);
    	
    	if (result) {
    		this.WriteToUserData(Fields.Group, input);
    	}
    	return result;
    }
    
    public String[] returnDatas(String locale) {
    	String datas[] = new String[Fields.values().length];
    	int loc = locale.equals("en") ? 0 : 1;
    	
    	for(Fields field: Fields.values()) {
    		int order = field.ordinal();		
    		datas[order] = (field.value(loc) + ": "  + regDatas.get(field));
    	}
    	return datas;
    }
}
