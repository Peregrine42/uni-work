package assessment.encoding;

import java.math.BigInteger;

public class Unicode implements Encoding {

	/**
	 * factory class to encapsulate the
	 * conversion functions for the Unicode 
	 * encoding standard
	 **/
	
	public PlainText plainText(String message) {
		return new UnicodePlainText(message);
	}
	
	public PlainText plainText(BigInteger i) {
		return new UnicodePlainText(i);
	}
	
	public CipherText cipherText(BigInteger i) {
		return new CipherText(i);
	}
	
	public CipherText cipherText(String message) {
		return new CipherText(message);
	}
	
}
