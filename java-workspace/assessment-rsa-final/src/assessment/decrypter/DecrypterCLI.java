package assessment.decrypter;

import java.io.IOException;

import assessment.encoding.Encoding;
import assessment.encoding.Unicode;
import assessment.file.SimpleFile;
import assessment.longstrings.OperationOverDelimitedString;
import assessment.rsa.PrivateKey;

public class DecrypterCLI {

	public static void main(String[] args) {
		// handle command line arguments
		args = setArguments(args);
		String keyPath = args[0];
		String inputPath = args[1];
		
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
		String decryptedMessage = decrypt(cipherTextFromFile, new PrivateKey(privateKeyString));
		
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
	
	private static String decrypt(String cipherText, PrivateKey key) {
		Encoding encoding = new Unicode();
		String seperator = "\n";
		
		Decrypter d = new Decrypter(key, encoding);
		OperationOverDelimitedString plainText = new OperationOverDelimitedString(cipherText, d, "\n");
		
		seperator = "";
		return plainText.makeString(seperator);
	}
	
	private static String[] setArguments(String[] args) {
		String keyPath = "private.key";
		String inputPath = "ciphertext.txt";
		if (args.length >= 1) {
			keyPath = args[0];
		}
		
		if (args.length >= 2) {
			inputPath = args[1];
		}
		return new String[] {keyPath, inputPath};
	}

}
