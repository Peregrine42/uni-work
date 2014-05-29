package assessment.encrypter;

import java.math.BigInteger;

import assessment.encoding.CipherText;
import assessment.encoding.Encoding;
import assessment.longstrings.StringOperation;
import assessment.rsa.PublicKey;

public class Encrypter implements StringOperation {

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
		return encrypt(s);
	}
	
}
