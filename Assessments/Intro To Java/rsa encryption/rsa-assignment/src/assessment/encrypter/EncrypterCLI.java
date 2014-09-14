package assessment.encrypter;

import java.io.IOException;

import assessment.encoding.Encoding;
import assessment.encoding.Unicode;
import assessment.file.SimpleFile;
import assessment.longstrings.OperationOverModularString;
import assessment.rsa.PublicKey;

public class EncrypterCLI {

	/**
	 * entry point for the encrypter command
	 * line program.
	 * 
	 * command line arguments:
	 * public key path  (relative), default: public.key
	 * message path     (relative), default: input.txt
	 * 
	 **/
	
	private static Encoding encoding = new Unicode();
	private static   String delimiter = "\n";
	private static      int sectionLength = 32;
	
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

	private static String encrypt(String message, PublicKey key) {
		Encrypter e = new Encrypter(key, encoding);
		OperationOverModularString cipherText = new OperationOverModularString(message, e, sectionLength);
		return cipherText.makeString(delimiter);
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
	
}
