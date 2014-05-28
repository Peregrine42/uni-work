package assessment.rsa;

import java.math.BigInteger;

public class PrivateKeyValueObject {
	public BigInteger d;
	public BigInteger n;
	
	PrivateKeyValueObject(BigInteger d, BigInteger n) {
		this.d = d;
		this.n = n;
	}
	
	public PrivateKeyValueObject(String input) {
		String[] parts = input.split(" ");
		this.d = new BigInteger(parts[0]);
		this.n = new BigInteger(parts[1]);
	}
	
	public String toString() {
		return d.toString() + " " + n.toString();
	}
}