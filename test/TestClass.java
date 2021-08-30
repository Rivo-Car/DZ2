
import org.junit.*;

import ua.tef.Model;
import ua.tef.View;

public class TestClass {
	
	Model M1 = new Model();
	Model M2 = new Model();
	Model M3 = new Model(1, 10);
	Model MD = new Model(3, 5);		
	int answerM1 =  ParseInt(M1);
	int answerM2 =  ParseInt(M2);
	int answerM3 =  ParseInt(M3);
	int answerMD =  ParseInt(MD);
	//Class<?> model = Model.class;
	
	@Test
        public void testEquals() {
	   Assert.assertTrue(M1.equalsToSolution(answerM1));
	   Assert.assertTrue(M2.equalsToSolution(answerM2));
	   Assert.assertTrue(M3.equalsToSolution(answerM3));
	   Assert.assertTrue(MD.equalsToSolution(answerMD));
	}
	
	@Test
	public void testStrToBounds() {
		String M1Bounds = M1.StringToBounds("");
		String M2Bounds = M2.StringToBounds("");
		String M3Bounds = M3.StringToBounds("");
		String MDBounds = MD.StringToBounds("");
		
		Assert.assertEquals(null, M1Bounds, "[0,100]: ");
		Assert.assertEquals(null, M2Bounds, "[0,100]: ");
		Assert.assertEquals(null, M3Bounds, "[1,10]: ");
		Assert.assertEquals(null, MDBounds, "[3,5]: ");
	}
		
	@Test
	public void testIsInBounds() {
		Assert.assertTrue(M1.isInBounds(answerM1));
		Assert.assertTrue(M3.isInBounds(answerM3));
		Assert.assertTrue(M2.isInBounds(0));
		Assert.assertTrue(MD.isInBounds(answerMD));	
		Assert.assertFalse(MD.isInBounds(answerM1));
		Assert.assertFalse(M3.isInBounds(0));
	} 
	
	@Test
	public void testCompareToSolution() {		
		Assert.assertEquals(M1.compareToSolutionAndChangeBounds(0), 1);
		Assert.assertEquals(M1.compareToSolutionAndChangeBounds(answerM1 + 2), 0);
		Assert.assertEquals(M2.compareToSolutionAndChangeBounds(answerM2 - 22), 1);
		Assert.assertEquals(M3.compareToSolutionAndChangeBounds(10), 0);
		Assert.assertNotEquals(MD.compareToSolutionAndChangeBounds(3), 0);
	}
	
	@Test
	public void testRand() {
		int[] set = new int[100];
		for(int i = 0; i < 10000000; i++) {
			Model M1 = new Model();
			++set[M1.getAnswer()];
		}
		for (int i : set) View.printMessage("" + i + ", ");
	}
	
	private int ParseInt(Model M) {
		return Integer.parseInt(M.answerToConsole(""));
	}
}
