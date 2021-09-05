package pack.main;
import java.util.*;

public class Model {
	public final static String[] Groups = {"FI-11", "FI-12", "FI-13", "FI-14"};
	public final static String[] Gruppy = {"ФІ-11", "ФІ-12", "ФІ-13", "ФІ-14"};
    private HashMap<Fields, String> regDatas;
    
    public Model() {
    	regDatas = new HashMap<Fields, String>();
    }
    
    public void WriteToUserData(Fields field, String Data) {
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
    
    public String[] returnDatas(String locale) {
    	String datas[] = new String[Fields.values().length];
    	
    	if (locale.equals("en")) {
    	
    		for(Fields field: Fields.values()) {
    			int order = field.ordinal();		
    		    datas[order] = (field.toString().replace("_", " ") + ": "  + regDatas.get(field));
    	    }   	   		
    	} else {
    		for(Fields field: Fields.values()) {
    			int order = field.ordinal();
    			Polia pole = Polia.values()[order];
    		    datas[order] = (pole.toString().replace("_", " ") + ": "  + regDatas.get(field));
    	    }
    	}
    	return datas;
    }
}