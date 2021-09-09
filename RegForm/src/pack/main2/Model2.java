package pack.main2;
import java.util.ArrayList;

import pack.main.Model;

public class Model2 {	
//    Model M1 = new Model("passat2131332");
//    Model M2 = new Model("ortrtrt21232133");
//	Model M3 = new Model("Passarter");
	private ArrayList<Model> UserList;
	
	public Model2() {
	    UserList = new ArrayList<Model>();
	}
	
	public Model2(Model...models) {
		this();
		for (Model m: models) UserList.add(m);
	}
	
	public void addToSet(Model m) {		
		UserList.add(m);
	}
	
	public void substitute(Model m1, Model m2) {
		UserList.set(UserList.indexOf(m1), m2);
	}
	
	
}
