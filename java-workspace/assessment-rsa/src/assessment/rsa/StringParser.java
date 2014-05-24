package assessment.rsa;

import java.math.BigInteger;

public class StringParser {

	int chunkSize;
	int unicodeDecimalLength;
	
	public StringParser(int size) {
		chunkSize = size;
		unicodeDecimalLength = 5;
	}
	
	public BigInteger[] convertToUnicodeInts(String text) {
		/**
		 * converts a string into an array of big integers based
		 * on their Unicode value.
		 */
		
		String[] messageChunks = splitMessage(text);
		BigInteger[] result = new BigInteger[messageChunks.length];
		for (int i = 0; i < messageChunks.length; i++) {
			String string = messageChunks[i];
			result[i] = stringToUnicodeNumber(string);
		}
		return result;
	}
	
	public String convertToUnicodeString(BigInteger[] bigInts) {
		/**
		 * converts an array of big integers into a Unicode string
		 */
		
		String result = "";
		for (int i = 0; i < bigInts.length; i++) {
			BigInteger value = bigInts[i];
			result += bigIntToString(value);
		}
		return result;
	}
	
	public BigInteger[] parseCipherText(String cipherText) {
		/**
		 * converts a string of the form:
		 * 45 534 2311
		 * into an array of big integers
		 */
		
		if (cipherText.isEmpty()) {
			return new BigInteger[0];
		}
		
		// split on spaces
		String[] ciphered_parts = cipherText.split(" ");
		
		// convert to big ints
		BigInteger[] big_ints = partsToBigInts(ciphered_parts);
		
		return big_ints;
	}
	
	public String concatenateBigInts(BigInteger[] bigInts) {
		/**
		 * concatenate a set of big integers into
		 * a string.
		 * so       [5113, 64, 723, 12323] 
		 * becomes  "5113 64 723 12323"
		 */
		
		String message = "";
		for (int i = 0; i < bigInts.length; i++) {
			message += bigInts[i].toString() + " ";
		}
		return message;
	}
	
	private BigInteger[] partsToBigInts(String[] s) {
		BigInteger[] result = new BigInteger[s.length];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = new BigInteger(s[i]);
		}
		
		return result;
	}
	
	private String bigIntToString(BigInteger b) {
		/**
		 * assumes the integer is a set of unicode values
		 * concatenated together like this:
		 * 1130010000101
		 * becomes:
		 * 113, 100, 101
		 * becomes:
		 * "ēde"
		 */
		
		// add zero padding
		String bigIntMessage = b.toString();
		int remainder = bigIntMessage.length() % unicodeDecimalLength;
		int extraZerosNeeded = unicodeDecimalLength - remainder;
		bigIntMessage = padWithZeros(bigIntMessage, extraZerosNeeded);
		
		// split into sets of numbers
		int amountOfCharacters = bigIntMessage.length()/unicodeDecimalLength;
		String[] parts = new String[amountOfCharacters];
		for (int i = 0; i < amountOfCharacters; i++) {
			parts[i] = bigIntMessage.substring(i*unicodeDecimalLength, (i*unicodeDecimalLength) + unicodeDecimalLength);
		}
		
		// convert to unicode
		String convertedMessage = "";
		for (int i = 0; i < parts.length; i++) {
			
			// treat the set as a decimal number and convert
			// to an integer
			int cc = Integer.parseInt(parts[i]);
			
			// convert that integer value to a char, 
			// completing the conversion
			char ccc = (char) cc;
			convertedMessage = convertedMessage + String.valueOf(ccc);
		}
		
		return convertedMessage;
	}
	
	private BigInteger stringToUnicodeNumber(String string) {
		/**
		 * takes a string and produces a BigInteger
		 * by converting each character to unicode numbers 
		 * and concatenating those numbers into a single
		 * big int
		 */
		
		String asUnicode = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			String asNumber = Integer.toString((int) c);
			
			int remainder = unicodeDecimalLength - asNumber.length();
			asNumber = padWithZeros(asNumber, remainder);
			
			asUnicode += asNumber;
		}
		
//		if (asUnicode.equals("")) {
//			return BigInteger.ZERO;
//		}
		
		BigInteger result = new BigInteger(asUnicode);
		return result;
	}
	
	private String[] splitMessage(String M) {
		if (M.isEmpty()) {
			return new String[0];
		}
		
		if (M.length() <= chunkSize) {
			String[] result = { M };
			return result;
		}
		
		int amountOfChunks = (M.length()/chunkSize);
		
		if (M.length() % chunkSize != 0) {
			amountOfChunks += 1;
		}

		String[] result = new String[amountOfChunks];
		
		String buffer = "";
		int arrayCounter = 0;
		for (int i = 0; i < M.length(); i++) {
			buffer += M.charAt(i);
			
			if (buffer.length() == chunkSize) {
				result[arrayCounter] = buffer;
				arrayCounter += 1;
				buffer = "";
			}
		}
		
		if (!buffer.equals("")) {
			result[arrayCounter] = buffer;
		}
		
		return result;
	}

	public static String padWithZeros(String input, int remainder) {
		for (int j = 0; j < remainder; j++) {
			input = "0" + input;
		}
		return input;
	}
	
//	public BigInteger[] convert(String message) {
//		String[] messageChunks = splitMessage(message);
//		BigInteger[] result = new BigInteger[messageChunks.length];
//		for (int i = 0; i < messageChunks.length; i++) {
//			String string = messageChunks[i];
//			result[i] = stringToUnicodeNumber(string);
//		}
//		return result;
//	}
	
}
