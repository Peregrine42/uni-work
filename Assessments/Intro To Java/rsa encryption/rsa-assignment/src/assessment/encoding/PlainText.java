package assessment.encoding;

import java.math.BigInteger;

public abstract class PlainText {

	/**
	 * wrapper class that handles the
	 * conversion between String and BigInteger
	 **/
	
	public static int unicodeDecimalLength = 5;
	public String text;
	
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
	
	public abstract String convertBigInteger(BigInteger b);
}
