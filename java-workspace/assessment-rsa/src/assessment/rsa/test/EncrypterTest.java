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

	public boolean isPrime(int number) {
		int j = 2;
		int result = 0;
		while (j <= number / 2)
		{
			if (number % j == 0)
			{
				result = 1;
			}
			j++;
		}
		
		if (result == 1) {
			return false;
		} else {
			return true;
		}
	}

}
