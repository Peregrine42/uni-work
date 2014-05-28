package assessment.rsa;

import java.io.IOException;

public class EncrypterCLI {
	
	public static void main(String[] args) {
		
		// handle command line arguments
		String keyPath = "public.key";
		String inputPath = "input.txt";
		if (args.length >= 1) {
			keyPath = args[0];
		}
		
		if (args.length >= 2) {
			inputPath = args[1];
		}
		
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
		String cipherText = new StringEncrypter(new PublicKeyValueObject(publicKeyString), 30).encrypt(messageFromFile);
		
		// write ciphertext to file
		try {
			new SimpleFile("ciphertext.txt").write(cipherText);
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
		
		System.out.println("Encryption successful.");
		System.out.println("Message:\n" + messageFromFile);
		System.out.println("Encrypted ciphertext:\n" + cipherText + "\n");
	}

}
