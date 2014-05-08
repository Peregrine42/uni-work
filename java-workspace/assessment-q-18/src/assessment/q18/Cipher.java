package assessment.q18;

import java.util.HashMap;
import java.util.Map;

public class Cipher {

	String text;
	
	public Cipher(String s) {
		text = s;
	}
	
	public String decrypt(char statisticallyMostCommonLetter) {
		char c;
		
		c = mostCommonLetter();
		
		int offset = findOffset(statisticallyMostCommonLetter, c);
		return translate(offset);
	}
	
	public char mostCommonLetter() {
		HashMap<Character, Integer> histogram = buildHistogram(text);
		char maxChar = getMostCommonLetter(histogram);
		return maxChar;
	}
	
	public static int findOffset(char letter, char letter2) {
		int value = (int) letter;
		int value2 = (int) letter2;
		return value - value2;
	}
	
	public String translate(int rotAmount) {
		String encoded = "";
		
		// step through input
		for (int i = 0; i < text.length(); i++) {
			
			char c = text.charAt(i);
			
			// ignore spaces
			if (c == ' ') {
				encoded += ' ';
				continue;
			}
			
			// do rotation
			c = rotate(c, rotAmount);
			
			encoded = encoded + c;
		}
		
		return encoded;
	}
	
	private static char rotate(char c, int rotAmount) {
		int valueOfA = 65;

		// convert char to a value
		int v = (int) c;
		
		// remove offset from value so we get the 
		// position of the letter in the alphabet
		// (zero-based)
		v -= valueOfA;
		v += rotAmount;
		
		// wrap the value round to between 0 and 25
		v = v % 26;
		if (v < 0) {
			v += 26;
		}
		
		// add the offset back on
		v += valueOfA;
		
		// convert back to char
		c = (char) v;
		return c;
	}
	
	private HashMap<Character, Integer> buildHistogram(String text) {
		// produces a hash with the following form:
		//			histogram = { 'A': 5,
		//						  'B': 2,
		//					   letter: frequency, etc }
		
		int length = text.length();
		HashMap<Character, Integer> histogram = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			char c = text.charAt(i);
			if (histogram.containsKey(c)) {
				int currentTotal = histogram.get(c);
				currentTotal += 1;
				histogram.put(c, currentTotal);
			} else {
				histogram.put(c, 1);
			}
		}
		
		return histogram;
	}
	
	private char getMostCommonLetter(Map<Character, Integer> histogram) {
		// gets the key with the highest value from the histogram
		// assumes a non-empty histogram
		
		int maxValue = 0;
		char maxChar = '0';		// error case - this will always be overwritten
								//              unless given an empty histogram
		for (Map.Entry<Character, Integer> entry : histogram.entrySet()) {
		    char key = entry.getKey();
		    int value = entry.getValue();

		    if (value > maxValue) {
		    	maxValue = value;
		    	maxChar = key;
		    }
		}
		
		return maxChar;
	}
}