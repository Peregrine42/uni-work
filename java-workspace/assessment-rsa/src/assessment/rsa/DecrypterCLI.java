package assessment.rsa;

import java.io.IOException;
import java.math.BigInteger;

public class DecrypterCLI {

	public static void main(String[] args) {
		String keyPath = "private.key";
		String inputPath = "ciphertext.txt";
		if (args.length >= 1) {
			keyPath = args[0];
		}
		
		if (args.length >= 2) {
			inputPath = args[1];
		}
		
		String privateKeyString;
		String cipherTextFromFile;
		try {
			// read in the private key
			privateKeyString = new SimpleFile(keyPath).read();
			// read in the cipher text
			cipherTextFromFile = new SimpleFile(inputPath).read();
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
			
		// decrypt the cipher text
		StringParser parser = new StringParser();
		BigInteger[] cipherTextAsInts = parser.parseCipherText(cipherTextFromFile);
		Decrypter dec = new Decrypter(new PrivateKey(privateKeyString));
		BigInteger[] decryptedTextAsInts = dec.decrypt(cipherTextAsInts);
		String decryptedMessage = parser.convertToUnicodeString(decryptedTextAsInts);
		
		// output
		System.out.println("Decryption successful.");
		System.out.println("Original ciphertext:\n" + cipherTextFromFile);
		System.out.println("Message reads:\n" + decryptedMessage);
		
		// write decrypted message to file
		try {
			new SimpleFile("output.txt").write(decryptedMessage);
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}

	}

}
