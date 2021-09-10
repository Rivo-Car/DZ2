package pack.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pack.main.Fields;
import pack.main.Model;
import pack.main.View;
import pack.main2.*;

/**
 * @author Rivo-Car
 *
 */
class TestModel {
	Model M11 = new Model("ASsssssss");
	Model M12 = new Model("211313bhmgb");
	Model M13 = new Model("Tycoon99");
    private Model2 M2 = new Model2(M11, M12, M13);
    Fields field = Fields.Login;
    
	@Test
	void TestIsAuthentic() {
		Assertions.assertTrue(M2.isAuthentic("Casserta"), "");
		Assertions.assertTrue(M2.isAuthentic("Passarella"), "");
		Assertions.assertTrue(M2.isAuthentic("211313bhmgbd"), "");
		Assertions.assertFalse(M2.isAuthentic("211313bhmgb"), "");
		Assertions.assertFalse(M2.isAuthentic("ASsssssss"), "");
		Assertions.assertTrue(M2.isAuthentic("ASssssSSss"), "");
	}
	
	@Test
	void TestMatches() {		
		String pattern = View.bundleString("regex.login.data");
		String[] ArrayString = Model.Groups;
		String[] UrrayString = Model.Gruppy;
		
		Assertions.assertTrue(M11.matches("Passart12", pattern, field));
		Assertions.assertTrue(M11.matches("Gorsows_12", pattern, field));
		Assertions.assertTrue(M11.matches("Gorsows-12", pattern, field));
		Assertions.assertTrue(M11.matches("12-Gorsows-12", pattern, field));
		Assertions.assertFalse(M11.matches("Gorsows", pattern, field));
		Assertions.assertFalse(M11.matches("Gоrsows3232", pattern, field));
		
		Assertions.assertTrue(M11.matches("FI-12", ArrayString));
		Assertions.assertTrue(M11.matches("ФІ-13", UrrayString));
		Assertions.assertFalse(M11.matches("ФI-13", UrrayString));
		Assertions.assertFalse(M11.matches("FI-15", ArrayString));		
	}
	
	@Test
	void TestMatchesFields() {
		Model M111 = new Model("ASsssssss");
		Model M112 = new Model("ASssssss");
		Model M121 = new Model("211313bhmgb");
		Model M122 = new Model("215313bhmgb");
		
		Assertions.assertTrue(Model.matches("ASsssssss", M111, field));
		Assertions.assertTrue(Model.matches("ASssssss", M112, field));
		Assertions.assertFalse(Model.matches("ASssssss", M111, field));
		Assertions.assertTrue(Model.matches("211313bhmgb", M121, field));
		Assertions.assertTrue(Model.matches("215313bhmgb", M122, field));
		Assertions.assertFalse(Model.matches("ASssssss", M121, field));		
	}

}
