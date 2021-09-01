package in.ashokit.beans.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import in.ashokit.beans.Calculator;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		Integer add = c.add(10, 20);
		assertEquals(30, add);
	}

}
