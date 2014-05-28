package assessment.rsa;

import java.math.BigInteger;

public class Encrypter {
	
	PublicKeyValueObject key;
	
	public Encrypter(PublicKeyValueObject key) {
		this.key = key;
	}
	
	public BigInteger[] encrypt(BigInteger[] message) {
		BigInteger[] encryptedInts = new BigInteger[message.length];
		for (int i = 0; i < message.length; i++) {
			encryptedInts[i] = encrypt(message[i]);
		}
		return encryptedInts;
		
	}
	
	BigInteger encrypt(BigInteger m) {
		BigInteger C = m.modPow(key.e, key.n);
		return C;
	}
}
