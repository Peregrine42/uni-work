package assessment.rsa;

import java.math.BigInteger;

public class UnicodeCipherText {

	// handles string to biginteger conversion
	
	static int unicodeDecimalLength = 5;
	
	String text;
	
	UnicodeCipherText(String s) {
		text = s;
	}
	
	public BigInteger toBigInteger() {
		return new BigInteger(text);
	}
	
	public String decrypt(PrivateKey key) {
		return convert(key.decrypt(toBigInteger()));
	}
	
	private String convert(BigInteger b) {
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
		
		String[] sections = splitter.splitAtInterval(messageString, unicodeDecimalLength);
		
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
	
	public static String padWithZeros(String input, int remainder) {
		for (int j = 0; j < remainder; j++) {
			input = "0" + input;
		}
		return input;
	}
	
}
