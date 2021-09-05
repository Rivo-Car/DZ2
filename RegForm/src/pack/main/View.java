package pack.main;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
	static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua", "UA"));  // Ukrainian
                    new Locale("en"));  // Eng
    public static final String tab = " ";
       
    public static void printMessage(String str) {
    	System.out.print(str);
    }
    
    public static void println(String str) {
    	System.out.println(str);
    }
    
    public static void concatAndPrint(String... strings) {
    	String res = "";
    	for(String s : strings) res += (tab + s);
    	printMessage(res.substring(1));
    }
    
    public static String bundleString(String... keys) {
    	String res = "";
    	for(String k: keys) res += bundle.getString(k);
    	return res;
    }
}