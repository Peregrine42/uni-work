package assessment.rsa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import assessment.rsa.StringParser;

public class StringParserTest {

	private StringParser parser;

	@Before
	public void initManipulator() {
		parser = new StringParser(5);
	}

	@Test
	public void convertToUnicodeIntsTest() {
		BigInteger[] expected = { new BigInteger("970009800099") };
		BigInteger[] actual = parser.convertToUnicodeInts("abc");
		assertArrayEquals(expected, actual);
	}

	@Test
	public void convertEmptyToUnicodeIntsTest() {
		BigInteger[] expected = { };
		BigInteger[] actual = parser.convertToUnicodeInts("");
		assertArrayEquals(expected, actual);
	}

	@Test
	public void convertToUnicodeIntsTestLong() {
		BigInteger[] expected = { new BigInteger("9700098000990010000101"), new BigInteger("0010200103") };
		BigInteger[] actual = parser.convertToUnicodeInts("abcdefg");
		assertArrayEquals(expected, actual);
	}

	@Test
	public void convertToUnicodeStringTest() {
		BigInteger[] bigInts = { new BigInteger("00100"), 
								 new BigInteger("00101"), 
								 new BigInteger("00102"), 
								 new BigInteger("00103") };
		assertEquals("defg", parser.convertToUnicodeString(bigInts));
	}

	@Test
	public void parseCipherTextTest() {

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
	public void parseEmptyCipherTextTest() {

		String cipherText = "";
		BigInteger[] expected = { };

		BigInteger[] actual = parser.parseCipherText(cipherText);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void concatenateBigIntsTest() {

		BigInteger[] bigInts = { new BigInteger("00100"), 
								 new BigInteger("00101"), 
								 new BigInteger("00102"), 
								 new BigInteger("00103") };
		String expected = "100 101 102 103 ";
		assertEquals(expected, parser.concatenateBigInts(bigInts));
	}

	@Test
	public void splitMessageTest() {
		splitMessageTestRoutine("abcdefghi", new String[] {"abcde", "fghi"});
		splitMessageTestRoutine("abcdefghij", new String[] {"abcde", "fghij"});
		splitMessageTestRoutine("a", new String[] {"a"});
		splitMessageTestRoutine("", new String[] {});
	}

	public void splitMessageTestRoutine(String message, String[] expected) {
		String[] result = parser.splitMessage(message);
		assertArrayEquals(expected, result);
	}

}
