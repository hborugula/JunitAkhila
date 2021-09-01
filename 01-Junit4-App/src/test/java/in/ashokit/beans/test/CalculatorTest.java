package in.ashokit.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import in.ashokit.beans.Calculator;

public class CalculatorTest {

	private static Calculator calc = null;

	@BeforeClass
	public static void init() {
		calc = new Calculator();
	}

	@AfterClass
	public static void destroy() {
		calc = null;
	}

	@Test
	public void testAdd() {
		Integer actualResult = calc.add(10, 20);
		Integer expectedResult = 30;
		assertEquals(expectedResult, actualResult);
	}
	

	@Test
	public void testMultiply() {
		Integer actualResult = calc.multiply(2, 3);
		Integer expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

}
