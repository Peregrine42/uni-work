package assessment.decrypter;

import java.math.BigInteger;

import assessment.encoding.Encoding;
import assessment.encoding.PlainText;
import assessment.longstrings.StringOperation;
import assessment.rsa.PrivateKey;

public class Decrypter implements StringOperation {

	private Encoding encoding;
	private PrivateKey key;
	
	public Decrypter(PrivateKey key, Encoding encoding) {
		this.encoding = encoding;
		this.key = key;
	}

	public String decrypt(String message) {
		BigInteger i = encoding.cipherText(message).toBigInteger();
		PlainText M = encoding.plainText(key.decrypt(i));
		return M.toString();
	}

	@Override
	public String stringTransform(String s) {
		return decrypt(s);
	}
	
}
