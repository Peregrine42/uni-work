package assessment.rsa;

import java.math.BigInteger;

public class PrivateKey {

	public BigInteger d;
	public BigInteger n;
	
	public PrivateKey(BigInteger d, BigInteger n) {
		this.d = d;
		this.n = n;
	}
	
	public PrivateKey(String input) {
		String[] parts = input.split(" ");
		this.d = new BigInteger(parts[0]);
		this.n = new BigInteger(parts[1]);
	}
	
	public String toString() {
		return d.toString() + " " + n.toString();
	}
	
	public PlainText decrypt(CipherText c) {
		BigInteger M = decrypt(c.toBigInteger());
		return new UnicodePlainText(M);
	}
	
	public BigInteger decrypt(BigInteger big_int) {
		return big_int.modPow(d, n);
	}
	
}
