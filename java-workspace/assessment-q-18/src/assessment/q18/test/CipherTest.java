package assessment.q18.test;
import static org.junit.Assert.*;

import org.junit.Test;

import assessment.q18.CipherText;

public class CipherTest {
	@Test
	public void mostCommonLetterTest() {
		CipherText c = new CipherText("AEBECED", " ");
		assertEquals('E', c.mostCommonChar());
		
		c = new CipherText("AAB", " ");
		assertEquals('A', c.mostCommonChar());
	}
	
	@Test
	public void findOffsetTest() {
		assertEquals(4, CipherText.findOffset('E', 'A'));
		assertEquals(-4, CipherText.findOffset('A', 'E'));
	}
	
	@Test
	public void translateTest() {
		CipherText c = new CipherText("ABC", " ");
		assertEquals("BCD", c.translate(1));
		
		c = new CipherText("ABC", " ");
		assertEquals("ZAB", c.translate(-1));
	}
	
	@Test
	public void translateIgnoresSpacesTest() {
		CipherText c = new CipherText("A B C", " ");
		assertEquals("B C D", c.translate(1));
	}
	
	@Test
	public void translateJustReturnsAnEmptyString() {
		CipherText c = new CipherText("", " ");
		assertEquals("", c.translate(1));
	}
	
	@Test
	public void integrationTest() {
		CipherText c = new CipherText("FFFFFBCD", " ");
		assertEquals("EEEEEABC", c.decrypt('E'));
		
		c = new CipherText("ABC", " ");
		assertEquals("EFG", c.decrypt('E'));
	}
	
	@Test
	public void integrationSpacesTest() {
		CipherText c = new CipherText("FFFFF BCDEG        ", " ");
		assertEquals("EEEEE ABCDF        ", c.decrypt('E'));
	}
	
	@Test
	public void integrationEmptyStringTest() {
		CipherText c = new CipherText("", " ");
		assertEquals("", c.decrypt('E'));
	}
}

