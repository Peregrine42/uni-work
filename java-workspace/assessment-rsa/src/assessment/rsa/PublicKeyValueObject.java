package assessment.rsa;

import java.math.BigInteger;

public class PublicKeyValueObject {
	public BigInteger e;
	public BigInteger n;
	
	PublicKeyValueObject(BigInteger e, BigInteger n) {
		this.e = e;
		this.n = n;
	}
	
	public PublicKeyValueObject(String input) {
		String[] parts = input.split(" ");
		this.e = new BigInteger(parts[0]);
		this.n = new BigInteger(parts[1]);
	}
	
	public String toString() {
		return e.toString() + " " + n.toString();
	}
}