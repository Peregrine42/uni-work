package assessment.rsa;

import java.math.BigInteger;

public class UnicodePlainText extends PlainText {

	public UnicodePlainText(String s) {
		super(s);
	}

	public UnicodePlainText(BigInteger i) {
		super(i);
	}
	
	public BigInteger toBigInteger() {
		/**
		 * takes a string and produces a BigInteger
		 * by converting each character to unicode numbers 
		 * and concatenating those numbers into a single
		 * big int
		 */
		
		String stringOfNumbers = "";
		for (int i = 0; i < text.length(); i++) {
			stringOfNumbers += unicodeValue(text.charAt(i));
		}
		
		BigInteger result = new BigInteger(stringOfNumbers);
		return result;
	}
	
	private static String unicodeValue(char c) {
		String unicodeValue = Integer.toString((int) c);
		
		int amountOfPadding = unicodeDecimalLength - unicodeValue.length();
		unicodeValue = padWithZeros(unicodeValue, amountOfPadding);
		
		return unicodeValue;
	}
	
	
	private static String padWithZeros(String input, int remainder) {
		for (int j = 0; j < remainder; j++) {
			input = "0" + input;
		}
		return input;
	}
	
	String convertBigInteger(BigInteger b) {
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
		
		String[] characterCodes = StringOperations.splitAtInterval(messageString, unicodeDecimalLength);
		
		// convert to unicode
		String convertedMessage = "";
		for (int i = 0; i < characterCodes.length; i++) {
			
			// assume the part is a decimal number and convert
			// to an integer
			int characterCode = Integer.parseInt(characterCodes[i]);
			
			// convert that integer value to a char, 
			// completing the conversion
			char messageCharacter = (char) characterCode;
			convertedMessage += String.valueOf(messageCharacter);
		}
		
		return convertedMessage;
	}
	
}
