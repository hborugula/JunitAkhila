package in.ashokit.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import in.ashokit.beans.PalindromeCheck;

public class PalindromeTest {

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "madam", "liril", "ashok" })
	public void testIsPalindrome(String str) {
		PalindromeCheck pc = new PalindromeCheck();
		boolean actual = pc.isPalindrome(str);
		assertTrue(actual);
	}

}
