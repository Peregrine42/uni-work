package assessment.rsa;

import java.math.BigInteger;

public class PlainText {

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
	
	private String convertBigInteger(BigInteger b) {
		/**
		 * assumes the integer is a set of unicode values
		 * concatenated together like this:
		 * 1130010000101
		 * becomes:
		 * 113, 100, 101
		 * becomes:
		 * "ēde"
		 */
		
		String messageString = b.toString();
		
		// add zero padding
		int remainder = messageString.length() % unicodeDecimalLength;
		int extraZerosNeeded = unicodeDecimalLength - remainder;
		messageString = padWithZeros(messageString, extraZerosNeeded);
		
		String[] sections = StringOperations.splitAtInterval(messageString, unicodeDecimalLength);
		
		// convert to unicode
		String convertedMessage = "";
		for (int i = 0; i < sections.length; i++) {
			
			// assume the part is a decimal number and convert
			// to an integer
			int characterCode = Integer.parseInt(sections[i]);
			
			// convert that integer value to a char, 
			// completing the conversion
			char messageCharacter = (char) characterCode;
			convertedMessage = convertedMessage + String.valueOf(messageCharacter);
		}
		
		return convertedMessage;
	}
}
