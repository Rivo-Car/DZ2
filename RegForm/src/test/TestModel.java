package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pack.main.Model;
import pack.main2.*;

/**
 * @author Rivo-Car
 *
 */
class TestModel {
    private Model2 M2 = new Model2(new Model("ASsssssss"), new Model("211313bhmgb"), new Model("Tycoon99"));
	
	@Test
	void TestIsAuthentic() {
		Assertions.assertTrue(M2.isAuthentic("Casserta"), "");
		Assertions.assertTrue(M2.isAuthentic("Passarella"), "");
		Assertions.assertTrue(M2.isAuthentic("211313bhmgbd"), "");
		Assertions.assertFalse(M2.isAuthentic("211313bhmgb"), "");
		Assertions.assertFalse(M2.isAuthentic("ASsssssss"), "");
		Assertions.assertTrue(M2.isAuthentic("ASssssSSss"), "");
	}

}
