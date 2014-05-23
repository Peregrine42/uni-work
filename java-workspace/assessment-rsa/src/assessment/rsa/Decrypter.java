package assessment.rsa;

import java.math.BigInteger;

import assessment.rsa.KeyGenerator.PrivateKey;

public class Decrypter {

	public BigInteger[] decrypt(BigInteger[] cipherInts, PrivateKey key) {
		BigInteger[] decrypted = new BigInteger[cipherInts.length];
		for (int i = 0; i < decrypted.length; i++) {
			decrypted[i] = decrypt(cipherInts[i], key);
		}
		
		return decrypted;
	}
	
	private static BigInteger decrypt(BigInteger big_int, PrivateKey key) {
		return big_int.modPow(key.d, key.n);
		
	}
}
