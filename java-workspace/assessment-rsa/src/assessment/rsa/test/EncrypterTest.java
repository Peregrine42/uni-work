package assessment.rsa.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;

import org.junit.Test;

import assessment.rsa.Encrypter;
import assessment.rsa.Encrypter.encryptedMessagePair;

public class EncrypterTest {

	@Test
	public void encryptTest() {
		Encrypter enc = new Encrypter();
		
		BigInteger p = BigInteger.probablePrime(64, new Random());
		BigInteger q = BigInteger.probablePrime(64, new Random());
		
		BigInteger n = p.multiply(q);
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
		BigInteger e = enc.getE();
		
		assertEquals(BigInteger.ONE, enc.gcd(phi, e));
		
		BigInteger d = enc.getD(e, phi);

		BigInteger M = enc.stringToUnicodeNumbers("hello");
		BigInteger C = M.modPow(e, n);
		BigInteger M_dec = C.modPow(d, n);

		assertTrue(M.equals(M_dec));

	}
	
	@Test
	public void encryptIntegrationTest() {
		Encrypter enc = new Encrypter();
		
		String M     = "hi there how are you today";
		encryptedMessagePair mp = enc.encrypt(M);
		String C     = mp.message;
		BigInteger d = mp.d;
		BigInteger n = mp.n;
		String M_dec = enc.decrypt(C, d, n);
		
		assertTrue(M.equals(M_dec));
	}
	
	@Test
	public void splitMessageTest() {
		Encrypter enc = new Encrypter();
		
		splitMessageTestRoutine(enc, "abcdefghi", new String[] {"abcde", "fghi"});
		splitMessageTestRoutine(enc, "abcdefghij", new String[] {"abcde", "fghij"});
		splitMessageTestRoutine(enc, "a", new String[] {"a"});
		splitMessageTestRoutine(enc, "", new String[] {});
		
	}
	
	public void splitMessageTestRoutine(Encrypter enc, String message, String[] expected) {
		String[] result = enc.splitMessage(message);
		assertTrue(compareArrays(expected, result));
	}
	
	public Boolean compareArrays(String[] a1, String[] a2) {
		for (int i = 0; i < a1.length; i++) {
			if (!a1[i].equals(a2[i])) {
				return false;
			}
		}
		return true;
	}
	
//	@Test
//	public void getETest() {
//		Encrypter e = new Encrypter();
//		assertTrue(isPrime(e.getE()));
//	}

	@Test
	public void gcdTest() {
		Encrypter e = new Encrypter();
		assertEquals(BigInteger.ONE, e.gcd(new BigInteger("13"), new BigInteger("60")));
		assertEquals(BigInteger.ONE, e.gcd(new BigInteger("21580"), new BigInteger("761")));
		assertEquals(new BigInteger("2"), e.gcd(new BigInteger("2"), new BigInteger("6")));
		assertEquals(new BigInteger("2"), e.gcd(new BigInteger("6"), new BigInteger("2")));
		assertEquals(new BigInteger("3"), e.gcd(new BigInteger("6"), new BigInteger("3")));
	}
	
	@Test
	public void getDTest() {
		Encrypter enc = new Encrypter();
		
		BigInteger phi = new BigInteger("60");
		BigInteger e   = new BigInteger("13");
		assertEquals(new BigInteger("37"), enc.getD(e, phi));
		
		BigInteger phi2 = new BigInteger("21580");
		BigInteger e2   = new BigInteger("761");
		assertEquals(new BigInteger("7061"), enc.getD(e2, phi2));
	}
	
	@Test
	public void stringToUnicodeNumbersTest() {
		Encrypter enc = new Encrypter();
		
		// Unicode
		// A: 00065
		// B: 00066
		// C: 00067
		
		BigInteger target1 = new BigInteger("6500066");
		assertTrue(target1.equals(enc.stringToUnicodeNumbers("AB")));
		
		BigInteger target2 = new BigInteger("670006500066");
		assertTrue(target2.equals(enc.stringToUnicodeNumbers("CAB")));
		
		BigInteger target3 = new BigInteger("640021500162");
		assertTrue(target3.equals(enc.stringToUnicodeNumbers("@ע")));
	}
	
	@Test
	public void numberToStringTest() {
		Encrypter enc = new Encrypter();
		
		BigInteger input1 = new BigInteger("6500066");
		assertEquals("AB", enc.numberToString(input1));
		
		BigInteger input2 = new BigInteger("64002150016200224");
		assertEquals("@ע�", enc.numberToString(input2));
	}
	
//	@Test
//	public void isPrimeTest() {
//		assertEquals(true,  isPrime(new BigInteger("1")));
//		assertEquals(true,  isPrime(new BigInteger("2")));
//		assertEquals(true,  isPrime(new BigInteger("3")));
//		assertEquals(true,  isPrime(new BigInteger("5")));
//		assertEquals(true,  isPrime(new BigInteger("227")));
//		assertEquals(false, isPrime(new BigInteger("228")));
//	}

	public boolean isPrime(BigInteger number) {
		/**
		 * Checks whether a number is prime or not. For a given number x it 
		 * steps through each number up to half of x to see if that number 
		 * goes into x with no remainder. 
		 * Adapted from:
		 * http://stackoverflow.com/questions/19514680/prime-number-test-java
		 */
		BigInteger j = new BigInteger("2");
		BigInteger halfNumber = number.divide(new BigInteger("2"));
		while (j.compareTo(halfNumber) <= 0) {
			if (number.mod(j).equals(BigInteger.ZERO)) {
				return false;
			}
			j.add(BigInteger.ONE);
		}
		return true;
	}

}
