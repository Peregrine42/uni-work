package assessment.rsa.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigInteger;
import assessment.rsa.KeyGenerator;

public class KeyGeneratorTest {
	@Test
	public void gcdTest() {
		assertEquals(BigInteger.ONE, KeyGenerator.gcd(new BigInteger("13"), new BigInteger("60")));
		assertEquals(BigInteger.ONE, KeyGenerator.gcd(new BigInteger("21580"), new BigInteger("761")));
		assertEquals(new BigInteger("2"), KeyGenerator.gcd(new BigInteger("2"), new BigInteger("6")));
		assertEquals(new BigInteger("2"), KeyGenerator.gcd(new BigInteger("6"), new BigInteger("2")));
		assertEquals(new BigInteger("3"), KeyGenerator.gcd(new BigInteger("6"), new BigInteger("3")));
	}
	
	@Test
	public void getDTest() {
		BigInteger phi = new BigInteger("60");
		BigInteger e   = new BigInteger("13");
		assertEquals(new BigInteger("37"), KeyGenerator.getD(e, phi));
		
		BigInteger phi2 = new BigInteger("21580");
		BigInteger e2   = new BigInteger("761");
		assertEquals(new BigInteger("7061"), KeyGenerator.getD(e2, phi2));
	}
}
