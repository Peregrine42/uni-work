package assessment.q18.test;
import static org.junit.Assert.*;

import org.junit.Test;

import assessment.q18.Cipher;

public class CipherTest {
	@Test
	public void mostCommonLetterTest() {
		Cipher c = new Cipher("AEBECED");
		assertEquals('E', c.mostCommonLetter());
		
		c = new Cipher("AAB");
		assertEquals('A', c.mostCommonLetter());
	}
	
	@Test
	public void findOffsetTest() {
		assertEquals(4, Cipher.findOffset('E', 'A'));
		assertEquals(-4, Cipher.findOffset('A', 'E'));
	}
	
	@Test
	public void translateTest() {
		Cipher c = new Cipher("ABC");
		assertEquals("BCD", c.translate(1));
		
		c = new Cipher("ABC");
		assertEquals("ZAB", c.translate(-1));
	}
	
	@Test
	public void translateIgnoresSpacesTest() {
		Cipher c = new Cipher("A B C");
		assertEquals("B C D", c.translate(1));
	}
	
	@Test
	public void translateJustReturnsAnEmptyString() {
		Cipher c = new Cipher("");
		assertEquals("", c.translate(1));
	}
	
	@Test
	public void integrationTest() {
		Cipher c = new Cipher("FFFFFBCD");
		assertEquals("EEEEEABC", c.decrypt('E'));
		
		c = new Cipher("ABC");
		assertEquals("EFG", c.decrypt('E'));
	}
}

