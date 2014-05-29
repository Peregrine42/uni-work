package assessment.rsa;

import java.io.IOException;

public class EncrypterCLI {

public static void main(String[] args) {
		
		// handle command line arguments
		args = setArguments(args);
		String keyPath = args[0];
		String inputPath = args[1];
		
		String publicKeyString;
		String messageFromFile;
		try {
			// read in the public key
			publicKeyString = new SimpleFile(keyPath).read();
			// read in the message
			messageFromFile = new SimpleFile(inputPath).read();
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
		
		// encrypt the message
		String cipherText = encrypt(messageFromFile, new PublicKey(publicKeyString));
		
		// write ciphertext to file
		try {
			new SimpleFile("ciphertext.txt").write(cipherText);
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
		
		// output to screen
		System.out.println("Encryption successful.");
		System.out.println("Message:\n" + messageFromFile);
		System.out.println("Encrypted ciphertext:\n" + cipherText + "\n");
	}

	private static String[] setArguments(String[] args) {
		String keyPath = "public.key";
		String inputPath = "input.txt";
		if (args.length >= 1) {
			keyPath = args[0];
		}
		
		if (args.length >= 2) {
			inputPath = args[1];
		}
		return new String[] {keyPath, inputPath};
	}

	private static String encrypt(String message, PublicKey key) {
		int sectionLength = 5;
		Encoding encoding = new Unicode();
		String seperator = "\n";
		
		Encrypter e = new Encrypter(key, encoding);
		RegularStringSections cipherText = new RegularStringSections(message, e, sectionLength);
		return cipherText.makeString(seperator);
	}
	
}
