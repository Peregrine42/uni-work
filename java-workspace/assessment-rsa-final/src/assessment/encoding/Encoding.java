package assessment.encoding;

import java.math.BigInteger;

import assessment.rsa.CipherText;
import assessment.rsa.PlainText;

public interface Encoding {

	public PlainText plainText(String message);
	
	public PlainText plainText(BigInteger i);
	
	public CipherText cipherText(BigInteger i);
	
	public CipherText cipherText(String message);
	
}
