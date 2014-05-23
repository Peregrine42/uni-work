package assessment.rsa;

import java.math.BigInteger;

public class Decrypter {

	PrivateKey key;
	
	public Decrypter(PrivateKey key) {
		this.key = key;
	}
	
	public BigInteger[] decrypt(BigInteger[] cipherInts) {
		BigInteger[] decrypted = new BigInteger[cipherInts.length];
		for (int i = 0; i < decrypted.length; i++) {
			decrypted[i] = decrypt(cipherInts[i]);
		}
		
		return decrypted;
	}
	
	private BigInteger decrypt(BigInteger big_int) {
		return big_int.modPow(key.d, key.n);
	}
}
