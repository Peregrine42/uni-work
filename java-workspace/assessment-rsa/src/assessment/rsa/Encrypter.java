package assessment.rsa;

import java.math.BigInteger;
import assessment.rsa.KeyGenerator.PublicKey;

public class Encrypter {
	
	public BigInteger[] encrypt(BigInteger[] message, PublicKey key) {
		BigInteger[] encryptedInts = new BigInteger[message.length];
		for (int i = 0; i < message.length; i++) {
			encryptedInts[i] = encrypt(message[i], key);
		}
		return encryptedInts;
		
	}
	
	private BigInteger encrypt(BigInteger m, PublicKey k) {
		BigInteger C = m.modPow(k.e, k.n);
		return C;
	}
	
//	private String joinBigInts(BigInteger[] bigInts) {
//		String result = "";
//		for (int i = 0; i < bigInts.length; i++) {
//			result += bigInts[i].toString();
//		}
//		return result;
//	}
}
