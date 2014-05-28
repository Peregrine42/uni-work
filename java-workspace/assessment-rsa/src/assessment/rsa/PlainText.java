package assessment.rsa;

import java.math.BigInteger;

public class PlainText {

	// handles string to biginteger conversion
	
	static int unicodeDecimalLength = 5;
	
	String text;
	
	public PlainText(String s) {
		text = s;
	}

	public String encrypt(PublicKey key) {
		return convert(key.encrypt(toBigInteger()));
	}
	
	public String convert(BigInteger i) {
		return i.toString() + " ";
	}
	
	public BigInteger toBigInteger() {
		/**
		 * takes a string and produces a BigInteger
		 * by converting each character to unicode numbers 
		 * and concatenating those numbers into a single
		 * big int
		 */
		
		String message = "";
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			String unicodeValue = Integer.toString((int) c);
			
			int amountOfPadding = unicodeDecimalLength - unicodeValue.length();
			unicodeValue = padWithZeros(unicodeValue, amountOfPadding);
			
			message += unicodeValue;
		}
		
		BigInteger result = new BigInteger(message);
		return result;
	}
	
	private static String padWithZeros(String input, int remainder) {
		for (int j = 0; j < remainder; j++) {
			input = "0" + input;
		}
		return input;
	}
	
}
