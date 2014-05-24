package junk.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.math.BigInteger;
import assessment.rsa.StringParser;

public class EncoderTest {
	@Test
	public void stringToUnicodeNumberTest() {
		// Unicode
		// A: 00065
		// B: 00066
		// C: 00067
		
		StringParser s = new StringParser(5);
		
		BigInteger target1 = new BigInteger("6500066");
		assertTrue(target1.equals(s.convertToUnicodeInts("AB")));
		
		BigInteger target2 = new BigInteger("670006500066");
		assertTrue(target2.equals(s.convertToUnicodeInts("CAB")));
		
		BigInteger target3 = new BigInteger("6401506");
		assertTrue(target3.equals(s.convertToUnicodeInts("@ע")));
	}
}
