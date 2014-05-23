package assessment.rsa;

import java.math.BigInteger;

public class Decoder {

	public String convert(BigInteger[] ints) {
		String result = "";
		for (int i = 0; i < ints.length; i++) {
			BigInteger value = ints[i];
			result += numberToString(value);
		}
		return result;
	}
	
	public String numberToString(BigInteger b) {
		int characterLength = 5;
		
		// add zero padding
		String message = b.toString();
		int remainder = characterLength - (message.length() % characterLength);
		message = Library.padWithZeros(message, remainder);
		
		// split into sets of numbers
		int amountOfCharacters = message.length()/characterLength;
		String[] parts = new String[amountOfCharacters];
		for (int i = 0; i < amountOfCharacters; i++) {
			parts[i] = message.substring(i*characterLength, (i*characterLength) + characterLength);
		}
		
		// convert to unicode
		String converted_message = "";
		for (int i = 0; i < parts.length; i++) {
			
			// treat the set as a decimal number and convert
			// to an integer
			int cc = Integer.parseInt(parts[i]);
			
			// convert that integer value to a char, 
			// completing the conversion
			char ccc = (char) cc;
			converted_message = converted_message + String.valueOf(ccc);
		}
		
		return converted_message;
	}
	
}
