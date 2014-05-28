package assessment.rsa;

import java.math.BigInteger;

public class CipherText {

	// handles string to biginteger conversion
	
	static int unicodeDecimalLength = 5;
	
	String text;
	
	public CipherText(String s) {
		text = s;
	}
	
	public CipherText(BigInteger i) {
		text = convertBigInteger(i);
	}
	
	public String toString() {
		return text.toString();
	}
	
	public BigInteger toBigInteger() {
		return new BigInteger(text.replaceAll(" ", ""));
	}
	
	private String convertBigInteger(BigInteger i) {
		return i.toString() + " ";
	}
	
}
