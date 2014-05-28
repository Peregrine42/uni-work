package assessment.rsa;

import java.io.IOException;

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
		String decryptedMessage = new StringDecrypter(new PrivateKey(privateKeyString)).decryptString(cipherTextFromFile);
		
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
