package assessment.rsa;

import java.math.BigInteger;

public class StringDecrypter {

	static int unicodeDecimalLength = 5;
	
	StringSplitter splitter;
	Decrypter decrypter;
	
	public StringDecrypter(PrivateKey key) {
		this.splitter = new StringSplitter();
		this.decrypter = new Decrypter(key);
	}
	
	public String decryptString(String cipherText) {
		
		String[] cipherTextSections = splitter.split(cipherText);
		
		String message = "";
		for (int i = 0; i < cipherTextSections.length; i++) {
			String cipherTextSection = cipherTextSections[i];
			BigInteger cipherTextAsInt = convertToBigInt(cipherTextSection);
			BigInteger decryptedTextAsInt = decrypter.decrypt(cipherTextAsInt);
			message += bigIntToString(decryptedTextAsInt);
		}
		
		return message;
	}
	
	private BigInteger convertToBigInt(String cipherTextSection) {
		return new BigInteger(cipherTextSection);
	}

	private String convertToUnicodeString(BigInteger[] bigInts) {
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
		String messageString = b.toString();
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
	
	private String[] splitIntoSections(String message, int sectionSize) {
		/**
		 * split the String into x-digit String parts
		 * "001130010000101"
		 * becomes:
		 * ["00113", "00100", "00101"]
		 */
		
		int amountOfCharacters = message.length()/sectionSize;
		String[] sections = new String[amountOfCharacters];
		for (int i = 0; i < amountOfCharacters; i++) {
			sections[i] = message.substring(i*sectionSize, (i*sectionSize) + sectionSize);
		}
		return sections;
	}
	
	public static String padWithZeros(String input, int remainder) {
		for (int j = 0; j < remainder; j++) {
			input = "0" + input;
		}
		return input;
	}
	
}
