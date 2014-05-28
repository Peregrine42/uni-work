package assessment.rsa;

import java.math.BigInteger;

public class Encrypter implements StringTransformer {

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
