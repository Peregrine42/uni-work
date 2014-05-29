package assessment.rsa;

import java.math.BigInteger;

public class CipherText {
	
	String text;
	
	public CipherText(String s) {
		text = s;
	}
	
	public CipherText(BigInteger i) {
		text = convertBigInteger(i);
	}
	
	public String toString() {
		return text;
	}
	
	public BigInteger toBigInteger() {
		return new BigInteger(text);
	}
	
	private String convertBigInteger(BigInteger i) {
		return i.toString();
	}
	
}
