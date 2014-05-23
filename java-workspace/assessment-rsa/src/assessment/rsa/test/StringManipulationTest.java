package assessment.rsa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigInteger;

import assessment.rsa.StringManipulator;

public class StringManipulationTest {
	
	@Test
	public void convertToUnicodeIntsTest() {
		StringManipulator parser = new StringManipulator();
		BigInteger[] expected = { new BigInteger("970009800099") };
		BigInteger[] actual = parser.convertToUnicodeInts("abc");
		assertTrue(expected[0].equals(actual[0]));
	}
	
	@Test
	public void convertToUnicodeIntsTestLong() {
		StringManipulator parser = new StringManipulator();
		BigInteger[] expected = { new BigInteger("9700098000990010000101"), new BigInteger("0010200103") };
		BigInteger[] actual = parser.convertToUnicodeInts("abcdefg");
		assertTrue(expected[0].equals(actual[0]));
		assertTrue(expected[1].equals(actual[1]));
	}
	
	@Test
	public void convertToUnicodeStringTest() {
		StringManipulator parser = new StringManipulator();
		BigInteger[] bigInts = { new BigInteger("00100"), 
				                 new BigInteger("00101"), 
				                 new BigInteger("00102"), 
				                 new BigInteger("00103") };
		assertEquals("defg", parser.convertToUnicodeString(bigInts));
	}
	
	@Test
	public void parseCipherTextTest() {
		StringManipulator parser = new StringManipulator();
		
		String cipherText = "10143 65305 00231";
		BigInteger[] expected = { new BigInteger("10143"), 
								  new BigInteger("65305"), 
								  new BigInteger("00231") };
 
		BigInteger[] actual = parser.parseCipherText(cipherText);
		assertTrue(expected[0].equals(actual[0]));
		assertTrue(expected[1].equals(actual[1]));
		assertTrue(expected[2].equals(actual[2]));
	}
	
	@Test
	public void concatenateBigIntsTest() {
		StringManipulator parser = new StringManipulator();
		
		BigInteger[] bigInts = { new BigInteger("00100"), 
                				 new BigInteger("00101"), 
                				 new BigInteger("00102"), 
                				 new BigInteger("00103") };
		String expected = "100 101 102 103 ";
		assertEquals(expected, parser.concatenateBigInts(bigInts));
	}
	
}
