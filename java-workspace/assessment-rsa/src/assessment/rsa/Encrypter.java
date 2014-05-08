package assessment.rsa;
import java.math.BigInteger;

public class Encrypter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] extendendEuclid(int a, int b) {
		/**
		 * A recursive function that, given a and b,
		 * calculates d, s and t from the equation:
		 * ax + by = g = gcd(a, b)
		 * Adapted from lecture powerpoint and:
		 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Extended_Euclidean_algorithm
		 */
		
		if (a == 0) {
			int[] result = { b, 0, 1 };
			return result;
		}
		
		int[] result1 = extendendEuclid(b % a, a);
		int g = result1[0];
		int y = result1[1];
		int x = result1[2];
		
		int[] result = { g, x - ((b / a) * y), y };
		return result;
	}
	
	public String numberToString(BigInteger b) {
		int characterLength = 7;
		
		// add zero padding
		String message = b.toString();
		int remainder = characterLength - (message.length() % characterLength);
		message = padWithZeros(message, remainder);
		
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
	
	public BigInteger stringToUnicodeNumbers(String string) {
		String asUnicode = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			String asNumber = Integer.toString((int) c);
			
			int remainder = 7 - asNumber.length();
			asNumber = padWithZeros(asNumber, remainder);
			
			asUnicode += asNumber;
		}
		
		BigInteger result = new BigInteger(asUnicode);
		return result;
	}
	
	public String padWithZeros(String input, int remainder) {
		for (int j = 0; j < remainder; j++) {
			input = "0" + input;
		}
		return input;
	}
	
	public int getD(int e, int phi) {
		/**
		 * Uses extendedEuclid to find r, a and b,
		 * Then uses a to select the right calculation 
		 * to find d.
		 */
		
		int[] result = extendendEuclid(e, phi);
//		int r = result[0];
		int a = result[1];
//		int b = result[2];
		
		int d = 0;
		if (a < 0) {
			d = a + phi;
		} else if (a >= phi) {
			d = a % phi;
		} else {
			d = a;;
		}
		return d;
	}
	
	public int getE() {
		/**
		 * Returns a prime number that is small
		 * enough to speed up calculation time, 
		 * but large enough to be secure.
		 * It contains few 1's in its binary
		 * representation, again to speed 
		 * calculation later.
		 * 
		 * Taken from:
		 * https://engineering.purdue.edu/kak/compsec/NewLectures/Lecture12.pdf
		 */
		
		return 65537;
	}
	
	public int gcd(int a, int b) {
		/**
		 * Returns the greatest common divisor
		 * between two numbers a and b.
		 * Uses a recursive version of the
		 * Euclidean Algorithm.
		 */
		
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
//	public String getFoo() {
//		return "foo";
//	}
//	
//	int[] extEuc(int a, int b) {
//		if (b == 0) {
//			int[] result = { a, 1, 0 };
//			return result;
//		} else {
//			int[] resultPrime = extEuc(b, a % b);
//			
//			int dPrime = resultPrime[0];
//			int xPrime = resultPrime[1];
//			int yPrime = resultPrime[2];
//			int[] result = { dPrime, yPrime, (int) ((int) xPrime - (Math.floor(a/b)*yPrime)) };
//			return result;
//		}
//	}
//	
//	int[] extEucIter(int a, int b) {
//		int prevx = 1;
//		int x = 0;
//		
//		int prevy = 0;
//		int y = 1;
//		
//		while (b > 0) {
//			double q = ((double) a) / ((double) b);
//			int q_as_int = (int) q;
//			
//			int oldx = x;
//			x = prevx - (q_as_int * x);
//			prevx = oldx;
//			
//			int oldy = y;
//			y = prevy - (q_as_int * y);
//			prevy = oldy;
//			
//			b = a % b;
//			a = b;
//		}
//		int[] result = { a, prevx, prevy };
//		return result;
//	}
//	
//	public int[] egcd(int a, int b) {
//		if (a == 0) {
//			int[] result = { b, 0, 1 };
//			return result;
//		} else {
//			int[] result = egcd(b % a, a);
//			int g = result[0];
//			int y = result[1];
//			int x = result[2];
//			
//			int[] answer = { g, x - (b/a)*y, y };
//			return answer;
//		}
//	}
}