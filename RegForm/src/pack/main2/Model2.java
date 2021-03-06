package pack.main2;
import java.util.ArrayList;

import pack.main.Fields;
import pack.main.Model;

public class Model2 {	
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
	
	public boolean isAuthentic(String LoginInput) {	
		
		for(Model m: UserList) {
			if(Model.matches(LoginInput, m, Fields.Login)) return false;
		}
		return true;
	}
		
}