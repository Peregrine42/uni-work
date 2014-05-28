package assessment.rsa;

import java.math.BigInteger;

public abstract class PlainText {

	// handles string to biginteger conversion
	
	static int unicodeDecimalLength = 5;
	
	String text;
	
	public PlainText(String s) {
		text = s;
	}
	
	public PlainText(BigInteger i) {
		text = convertBigInteger(i);
	}
	
	public String toString() {
		return text.toString();
	}
	
	public abstract BigInteger toBigInteger();
	
	abstract String convertBigInteger(BigInteger b);
}
