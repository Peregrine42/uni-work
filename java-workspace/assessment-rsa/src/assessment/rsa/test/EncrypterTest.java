package assessment.rsa.test;

import static org.junit.Assert.*;

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
		
		phi = 21580;
		e   = 761;
		assertEquals(7061, enc.getD(e, phi));
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
		 * goes into x equally. 
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
