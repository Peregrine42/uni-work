package assessment.rsa;

import java.math.BigInteger;

public class CipherTextDecoder {
	public BigInteger[] decode(String cipherText) {
		// split on spaces
		String[] ciphered_parts = cipherText.split(" ");
		
		// convert to big ints
		BigInteger[] big_ints = partsToBigInts(ciphered_parts);
		
		return big_ints;
	}
	
	private BigInteger[] partsToBigInts(String[] s) {
		BigInteger[] result = new BigInteger[s.length];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = new BigInteger(s[i]);
		}
		
		return result;
	}
}
