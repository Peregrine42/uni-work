package assessment.rsa;

import java.math.BigInteger;
import java.util.Random;

public class OldEncrypter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// value object
	public class Message {
		// generation
		public BigInteger p;
		public BigInteger q;
		public BigInteger phi;
		
		// private key
		public BigInteger d;
	//  public BigInteger n;
		
		// public key
		public BigInteger e;
		public BigInteger n;
		
		// message
		public String message;
		
		Message(String m) {
			message = m;
		}
	}
	
	public class PublicKey {
		public BigInteger e;
		public BigInteger n;
		
		PublicKey(BigInteger e, BigInteger n) {
			this.e = e;
			this.n = n;
		}
	}
	
	public class PrivateKey {
		public BigInteger d;
		public BigInteger n;
		
		PrivateKey(BigInteger d, BigInteger n) {
			this.d = d;
			this.n = n;
		}
	}
	
	public PublicKey publicKey;
	private PrivateKey privateKey;
	
	private class InitialValues {
		public BigInteger p;
		public BigInteger q;
		public BigInteger phi;
		public BigInteger e;
		
		InitialValues() {
			e = getE();
			p = BigInteger.probablePrime(64, new Random());
			q = BigInteger.probablePrime(64, new Random());
			phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
		}
		
		public boolean coprime() {
			return (BigInteger.ONE.compareTo(gcd(phi, e)) == 0);
		}
		
		public BigInteger getN() {
			return p.multiply(q);
		}
		
		public BigInteger getE() {
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
			
			return new BigInteger("65537");
		}

		public BigInteger getPhi() {
			return phi;
		}
	}
	
	public PublicKey generate() {
		/**
		 * randomly sets p and q, calculates phi, 
		 * then makes sure phi is coprime with e
		 * and generates the public and private keys.
		 */
		InitialValues values = makeEandPhiCoprime();
		privateKey = new PrivateKey(getD(values.getE(), values.getPhi()), values.getN());
		publicKey = new PublicKey(values.getE(), values.getN());
		
		return publicKey;
	}
	
	private InitialValues makeEandPhiCoprime() {
		InitialValues values;
		do {
			values = new InitialValues();
		} while (!values.coprime());
		return values;
	}
	
	public PublicKey getPublicKey() {
		return this.publicKey;
	}
	
	public String decrypt(String message) {
		/**
		 * takes an encrypted message string
		 * and returns the original message
		 * 
		 * assumes that the message is split into
		 * the same size of character chunks as
		 * it was when it was encrypted
		 */
		
		// split on spaces
		String[] ciphered_parts = message.split(" ");
		
		// convert to big ints
		BigInteger[] big_ints = partsToBigInts(ciphered_parts);
		
		// decrypt
		BigInteger[] decrypted = decryptArray(big_ints, privateKey.d, privateKey.n);
		
		// convert to strings
		String[] stringArray = numbersToStrings(decrypted);
		
		// join together
		String result = joinStringArray(stringArray);
		
		return result;
	}
	
	private String joinStringArray(String[] stringArray) {
		// join together
		String result = "";
		for (int i = 0; i < stringArray.length; i++) {
			result += stringArray[i];
		}
		return result;
	}
	
	private String[] numbersToStrings(BigInteger[] numbers) {
		String[] result = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numberToString(numbers[i]);
		}
		return result;
	}
	
	// move to message class?
	private Message pickPQandPhi(Message m) {
		m.p = BigInteger.probablePrime(64, new Random());
		m.q = BigInteger.probablePrime(64, new Random());
		
		// phi = (p-1)*(q-1)
		m.phi = (m.p.subtract(BigInteger.ONE)).multiply((m.q.subtract(BigInteger.ONE)));
		return m;
	}
	
	// move to message class?
	private BigInteger[] pickPQandPhi() {
		BigInteger[] result = new BigInteger[3];
		result[0] = BigInteger.probablePrime(64, new Random());		// p
		result[1] = BigInteger.probablePrime(64, new Random());		// q
		
		// phi = (p-1)*(q-1)
		result[2] = (result[0].subtract(BigInteger.ONE)).multiply((result[1].subtract(BigInteger.ONE)));
		return result;
	}
	
	// move to message class?
	private Message makeEandPhiCoprime(Message m) {
		m.e = getE();
		pickPQandPhi(m);
		while (BigInteger.ONE.compareTo(gcd(m.phi, m.e)) != 0) {
			pickPQandPhi(m);
		}
		return m;
	}
	
	// move to message class?
	public encryptedMessagePair encrypt(String M) {
		Message m = makeEandPhiCoprime(new Message(M));
		
		m.n = m.p.multiply(m.q);
		m.d = getD(m.e, m.phi);
		
		String[] M_parts = splitMessage(M);
		BigInteger[] encrypted_message_parts = encryptParts(M_parts, m);
		String result = joinBigInts(encrypted_message_parts);
		
		return new encryptedMessagePair(result, m.d, m.n);
	}
	
	// move to message class?
	private String joinBigInts(BigInteger[] bigInts) {
		String result = "";
		for (int j = 0; j < bigInts.length; j++) {
			result += bigInts[j].toString() + " ";
		}
		
		return result;
	}
	
	// move to message class?
	private BigInteger[] encryptParts(String[] M_parts, Message m) {
		BigInteger[] encrypted_message_parts = new BigInteger[M_parts.length];
		for (int i = 0; i < encrypted_message_parts.length; i++) {
			 BigInteger asUnicodeNumbers = stringToUnicodeNumbers(M_parts[i]);
			 BigInteger C = asUnicodeNumbers.modPow(m.e, m.n);
			 encrypted_message_parts[i] = C;
		}
		
		return encrypted_message_parts;
	}
	
	public String decrypt(String C, BigInteger d, BigInteger n) {
		// split on spaces
		String[] ciphered_parts = C.split(" ");
		
		// convert to big ints
		BigInteger[] big_ints = partsToBigInts(ciphered_parts);
		
		// decrypt to strings
		BigInteger[] decrypted = decryptArray(big_ints, d, n);
		
		// join together
		String result = "";
		for (int i = 0; i < decrypted.length; i++) {
			result += numberToString(decrypted[i]);
		}
		
		return result;
	}
	
	private BigInteger[] decryptArray(BigInteger[] big_ints, BigInteger d, BigInteger n) {
		BigInteger[] decrypted = new BigInteger[big_ints.length];
		for (int i = 0; i < decrypted.length; i++) {
			decrypted[i] = big_ints[i].modPow(d, n);
		}
		
		return decrypted;
	}
	
	private BigInteger[] partsToBigInts(String[] s) {
		BigInteger[] result = new BigInteger[s.length];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = new BigInteger(s[i]);
		}
		
		return result;
	}
	
	public class encryptedMessagePair {
		public String message;
		public BigInteger d;
		public BigInteger n;
		
		encryptedMessagePair(String message, BigInteger d, BigInteger n) {
			this.message = message;
			this.d = d;
			this.n = n;
		}
	}
	
	public String[] splitMessage(String M) {
		int chunkSize = 5;
		
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
	
	public BigInteger[] extendendEuclid(BigInteger a, BigInteger b) {
		/**
		 * A recursive function that, given a and b,
		 * calculates d, s and t from the equation:
		 * ax + by = g = gcd(a, b)
		 * Adapted from lecture powerpoint and:
		 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Extended_Euclidean_algorithm
		 */
		
		if (a.equals(BigInteger.ZERO)) {
			BigInteger[] result = { b, BigInteger.ZERO, BigInteger.ONE };
			return result;
		}
		
		BigInteger[] result1 = extendendEuclid(b.mod(a), a);
		BigInteger g = result1[0];
		BigInteger y = result1[1];
		BigInteger x = result1[2];
		
		BigInteger[] result = { g, x.subtract(b.divide(a).multiply(y)), y };
		return result;
	}
	
	public String numberToString(BigInteger b) {
		int characterLength = 5;
		
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
			
			int remainder = 5 - asNumber.length();
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
	
	public BigInteger getD(BigInteger e, BigInteger phi) {
		/**
		 * Uses extendedEuclid to find r, a and b,
		 * Then uses a to select the right calculation 
		 * to find d.
		 */
		
		BigInteger[] result = extendendEuclid(e, phi);
//		BigInteger r = result[0];
		BigInteger a = result[1];
//		BigInteger b = result[2];
		
		BigInteger d = BigInteger.ZERO;
		if (a.compareTo(BigInteger.ZERO) < 0) {
			d = a.add(phi);
		} else if (a.compareTo(phi) >= 0) {
			d = a.mod(phi);
		} else {
			d = a;
		}
		return d;
	}
	
	public BigInteger getE() {
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
		
		return new BigInteger("65537");
	}
	
	public BigInteger gcd(BigInteger a, BigInteger b) {
		/**
		 * Returns the greatest common divisor
		 * between two numbers a and b.
		 * Uses a recursive version of the
		 * Euclidean Algorithm.
		 */
		
		if (b.equals(BigInteger.ZERO)) {
			return a;
		} else {
			return gcd(b, a.mod(b));
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