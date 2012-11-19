package gingi.junit4;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

	@Test
	public void testAdd(){
		Calculator calculator = new Calculator();
		double result = calculator.add(10, 50);
		assertEquals(60, result, 0);
		
	}
	
	/*	private int nbErrors = 0;
	public void testAdd(){
		Calculator claculator = new Calculator();
		double result = claculator.add(10, 50);
		if (result != 60) {
			throw new IllegalStateException("Bad result: " + result);
		}
	}
	public static void main(String[] args) {
		CalculatorTest test = new CalculatorTest();
		try {
			test.testAdd();
		} catch (Throwable e) {
			test.nbErrors++;
			e.printStackTrace();
		}
		if (test.nbErrors > 0) {
			throw new IllegalStateException("There were " + test.nbErrors + " error(s)");
		}
	}
*/
}
