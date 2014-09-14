package assessment.encrypter;

import java.math.BigInteger;

import assessment.encoding.CipherText;
import assessment.encoding.Encoding;
import assessment.longstrings.StringOperation;
import assessment.rsa.PublicKey;

public class Encrypter implements StringOperation {

	/**
	 * Controller class that combines an encoding
	 * and a key with a message to produce a string.
	 * Uses the PlainText and CipherText classes.
	 */
	
	private Encoding encoding;
	private PublicKey key;

	public Encrypter(PublicKey key, Encoding encoding) {
		super();
		this.encoding = encoding;
		this.key = key;
	}

	public String encrypt(String message) {
		BigInteger m = encoding.plainText(message).toBigInteger();
		CipherText C = encoding.cipherText(key.encrypt(m));
		
		return C.toString();
	}

	@Override
	public String stringTransform(String s) {
		/**
		 * Provided to fulfil the StringOperation interface.
		 * Called on String sections.
		 */
		
		return encrypt(s);
	}
	
}
