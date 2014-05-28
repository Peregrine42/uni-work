package assessment.rsa;

import java.math.BigInteger;

public class Decrypter implements StringTransformer {

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
