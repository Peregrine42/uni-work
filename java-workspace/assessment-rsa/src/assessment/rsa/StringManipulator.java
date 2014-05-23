package assessment.rsa;

import java.math.BigInteger;

public class StringManipulator {

	int chunkSize = 5;
	
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
			result += chunkToString(value);
		}
		return result;
	}
	
	public BigInteger[] parseCipherText(String cipherText) {
		/**
		 * converts a string of the form:
		 * 45 534 2311
		 * into an array of big integers
		 */
		
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
	
	private String chunkToString(BigInteger b) {
		// add zero padding
		String message = b.toString();
		int remainder = chunkSize - (message.length() % chunkSize);
		message = Library.padWithZeros(message, remainder);
		
		// split into sets of numbers
		int amountOfCharacters = message.length()/chunkSize;
		String[] parts = new String[amountOfCharacters];
		for (int i = 0; i < amountOfCharacters; i++) {
			parts[i] = message.substring(i*chunkSize, (i*chunkSize) + chunkSize);
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
		 * takes a string and produces a big int
		 * by converting each character to unicode numbers 
		 * and concatenating those numbers into a single
		 * big int
		 */
		
		String asUnicode = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			String asNumber = Integer.toString((int) c);
			
			int remainder = chunkSize - asNumber.length();
			asNumber = Library.padWithZeros(asNumber, remainder);
			
			asUnicode += asNumber;
		}
		
		BigInteger result = new BigInteger(asUnicode);
		return result;
	}
	
	private String[] splitMessage(String M) {
		int length = (M.length()/chunkSize) + 1;
		if (M.isEmpty()) {
			length = 0;
		}
		
		String[] result = new String[length];
		
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
