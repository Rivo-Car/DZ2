package pack.main2;

import pack.main.View;

public class UnicityException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnicityException() {
		this(View.bundleString("input.notauthentic.data"));
	}
	
	public UnicityException(String str) {
		View.println(str);
	}
}