package assessment.rsa;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {

	public PublicKey publicKey;
	private PrivateKey privateKey;
	private int primeLength;
	
	public KeyGenerator(int primeLength) {
		this.primeLength = primeLength;
		generate();
	}
	
	public PublicKey generate() {
		/**
		 * randomly sets p and q, calculates phi, 
		 * then makes sure phi is coprime with e
		 * and generates the public and private keys.
		 */
		InitialValues values = makeEandPhiCoprime();
		privateKey = new PrivateKey(getD(values.getE(), values.getPhi()), values.getN());
		publicKey = new PublicKey(values.getE(), values.getN());
		
		return publicKey;
	}
	
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	
	public PublicKey getPublicKey() {
		return publicKey;
	}
	
	public BigInteger[] decrypt(BigInteger[] big_ints) {
		/**
		 * takes a message as integers, and returns
		 * the decrypted version of those integers
		 */
		
		// decrypt
		BigInteger[] decrypted = decryptArray(big_ints, privateKey.d, privateKey.n);
		return decrypted;
	}
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		/**
		 * Returns the greatest common divisor
		 * between two numbers a and b.
		 * Uses a recursive version of the
		 * Euclidean Algorithm.
		 */
		
		if (b.equals(BigInteger.ZERO)) {
			return a;
		} else {
			return gcd(b, a.mod(b));
		}
	}
	
	public static BigInteger getD(BigInteger e, BigInteger phi) {
		/**
		 * Uses extendedEuclid to find r, a and b,
		 * Then uses a to select the right calculation 
		 * to find d.
		 */
		
		BigInteger[] result = extendendEuclid(e, phi);
//		BigInteger r = result[0];
		BigInteger a = result[1];
//		BigInteger b = result[2];
		
		BigInteger d = BigInteger.ZERO;
		if (a.compareTo(BigInteger.ZERO) < 0) {
			d = a.add(phi);
		} else if (a.compareTo(phi) >= 0) {
			d = a.mod(phi);
		} else {
			d = a;
		}
		return d;
	}
	
	private class InitialValues {
		public BigInteger p;
		public BigInteger q;
		public BigInteger phi;
		public BigInteger e;
		
		InitialValues() {
			e = getE();
			p = BigInteger.probablePrime(primeLength, new Random());
			q = BigInteger.probablePrime(primeLength, new Random());
			phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
		}
		
		public boolean coprime() {
			return (BigInteger.ONE.compareTo(gcd(phi, e)) == 0);
		}
		
		public BigInteger getN() {
			return p.multiply(q);
		}
		
		public BigInteger getE() {
			/**
			 * Returns a prime number that is small
			 * enough to speed up calculation time, 
			 * but large enough to be secure.
			 * It contains few 1's in its binary
			 * representation, again to speed 
			 * calculation later.
			 * 
			 * Taken from:
			 * https://engineering.purdue.edu/kak/compsec/NewLectures/Lecture12.pdf
			 */
			
			return new BigInteger("65537");
		}

		public BigInteger getPhi() {
			return phi;
		}
	}
	
	private static BigInteger[] extendendEuclid(BigInteger a, BigInteger b) {
		/**
		 * A recursive function that, given a and b,
		 * calculates d, s and t from the equation:
		 * ax + by = g = gcd(a, b)
		 * Adapted from UCS lecture powerpoint and:
		 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Extended_Euclidean_algorithm
		 */
		
		if (a.equals(BigInteger.ZERO)) {
			BigInteger[] result = { b, BigInteger.ZERO, BigInteger.ONE };
			return result;
		}
		
		BigInteger[] result1 = extendendEuclid(b.mod(a), a);
		BigInteger g = result1[0];
		BigInteger y = result1[1];
		BigInteger x = result1[2];
		
		BigInteger[] result = { g, x.subtract(b.divide(a).multiply(y)), y };
		return result;
	}
	
	private static BigInteger[] decryptArray(BigInteger[] big_ints, BigInteger d, BigInteger n) {
		BigInteger[] decrypted = new BigInteger[big_ints.length];
		for (int i = 0; i < decrypted.length; i++) {
			decrypted[i] = big_ints[i].modPow(d, n);
		}
		
		return decrypted;
	}
	
	private InitialValues makeEandPhiCoprime() {
		InitialValues values;
		do {
			values = new InitialValues();
		} while (!values.coprime());
		return values;
	}
	
	
}
