package assessment.rsa;

import java.math.BigInteger;

public class PublicKey {
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
	
	public CipherText encrypt(PlainText p) {
		BigInteger C = encrypt(p.toBigInteger());
		return new CipherText(C);
	}
	
	public BigInteger encrypt(BigInteger m) {
		BigInteger C = m.modPow(e, n);
		return C;
	}
}
