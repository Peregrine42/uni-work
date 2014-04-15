package assessment.rsa.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import assessment.rsa.Encrypter;

public class EncrypterTest {

	@Test
	public void test() {
		Encrypter e = new Encrypter();
		assertEquals("foo", e.getFoo());
	}

	@Test
	public void getETest() {
		Encrypter e = new Encrypter();
		assertEquals(true, isPrime(e.getE()));
	}

	@Test
	public void gcdTest() {
		Encrypter e = new Encrypter();
		assertEquals(1, e.gcd(13, 60));
		assertEquals(1, e.gcd(21580, 761));
		assertEquals(2, e.gcd(2, 6));
		assertEquals(2, e.gcd(6, 2));
		assertEquals(3, e.gcd(6, 3));
	}
	
	@Test
	public void modularInverseTest() {
		Encrypter enc = new Encrypter();
		
		int phi = 60;
		int e   = 13;
		assertEquals(37, enc.getD(e, phi));
		
		int phi2 = 21580;
		int e2   = 761;
		assertEquals(7061, enc.getD(e2, phi2));
	}
	
	@Test
	public void stringToUnicodeNumbersTest() {
		Encrypter enc = new Encrypter();
		
		// Unicode
		// A: 0041
		// B: 0042
		// C: 0043
		
		BigInteger target1 = new BigInteger("00410042");
		assertTrue(target1.equals(enc.stringToUnicodeNumbers("AB")));
		
		BigInteger target2 = new BigInteger("004300410042");
		assertTrue(target2.equals(enc.stringToUnicodeNumbers("CAB")));
	}
	
	@Test
	public void isPrimeTest() {
		assertEquals(true, isPrime(1));
		assertEquals(true, isPrime(2));
		assertEquals(true, isPrime(3));
		assertEquals(true, isPrime(5));
		assertEquals(true, isPrime(227));
		assertEquals(false, isPrime(228));
	}

	public boolean isPrime(int number) {
		/**
		 * Checks whether a number is prime or not. For a given number x it 
		 * steps through each number up to half of x to see if that number 
		 * goes into x with no remainder. 
		 * Adapted from:
		 * http://stackoverflow.com/questions/19514680/prime-number-test-java
		 */
		int j = 2;
		int halfNumber = number / 2;
		while (j <= halfNumber) {
			if (number % j == 0) {
				return false;
			}
			j++;
		}
		return true;
	}

}
