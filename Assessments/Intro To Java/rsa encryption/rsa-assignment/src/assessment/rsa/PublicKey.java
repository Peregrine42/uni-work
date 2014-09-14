package assessment.rsa;

import java.math.BigInteger;

public class PublicKey {
	/**
	 * Encrypts a BigInteger, producing a BigInteger
	 * 
	 * Can be constructed from BigIntegers
	 * or a string.
	 **/
	
	public BigInteger e;
	public BigInteger n;
	
	public PublicKey(BigInteger e, BigInteger n) {
		this.e = e;
		this.n = n;
	}
	
	public PublicKey(String input) {
		String[] parts = input.split(" ");
		this.e = new BigInteger(parts[0]);
		this.n = new BigInteger(parts[1]);
	}
	
	public String toString() {
		return e.toString() + " " + n.toString();
	}
	
	public BigInteger encrypt(BigInteger m) {
		BigInteger C = m.modPow(e, n);
		return C;
	}
}
