package pack.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(View.s);
     Controller c = new Controller(new Model(), new View());
     c.processUser();
	}

}
