package assessment.rsa;

import java.math.BigInteger;

public class StringEncrypter {

	/**
	 * splits a given string up using a splitter
	 * converts the string to an int
	 * encrypts the int
	 * converts the int to a string
	 */
	
	static int unicodeDecimalLength = 5;
	
	private Encrypter encrypter;
	private StringSplitter splitter;
	private int chunkSize;
	
	public StringEncrypter(PublicKey key, int chunkSize) {
		this.chunkSize = chunkSize;
		this.splitter = new StringSplitter();
		this.encrypter = new Encrypter(key);
	}
	
	public String encrypt(String message) {
		String[] subStrings = splitter.splitAtInterval(message, chunkSize);
		
		String encryptedMessage = "";
		for (int i = 0; i < subStrings.length; i++) {
			encryptedMessage += encryptSubString(subStrings[i]) + " ";
		}
		return encryptedMessage;
	}
	
	public String encryptSubString(String subString) {
		BigInteger chunkAsInt = stringToUnicodeNumber(subString);
		BigInteger encryptedChunkAsInt = encrypter.encrypt(chunkAsInt);
		return encryptedChunkAsInt.toString();
	}
	
	public BigInteger stringToUnicodeNumber(String string) {
		/**
		 * takes a string and produces a BigInteger
		 * by converting each character to unicode numbers 
		 * and concatenating those numbers into a single
		 * big int
		 */
		
		String message = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
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
	
//	private String concatenateBigInts(BigInteger[] bigInts) {
//		/**
//		 * concatenate a set of big integers into
//		 * a string.
//		 * so       [5113, 64, 723, 12323] 
//		 * becomes  "5113 64 723 12323"
//		 */
//		
//		String message = "";
//		for (int i = 0; i < bigInts.length; i++) {
//			message += bigInts[i].toString() + " ";
//		}
//		return message;
//	}
	
//	private BigInteger convertToUnicodeInts(String text) {
//		/**
//		 * converts a string into an array of big integers based
//		 * on their Unicode value.
//		 */
//		
//		return stringToUnicodeNumber(text);
//	}
	
}
