package assessment.rsa;

import java.io.IOException;
import java.math.BigInteger;

public class EncrypterCLI {

	public static void main(String[] args) {
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
		StringParser manipulator = new StringParser(7);
		BigInteger[] messageAsInts = manipulator.convertToUnicodeInts(messageFromFile);
		Encrypter enc = new Encrypter(new PublicKey(publicKeyString));
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts);
		String cipherText = manipulator.concatenateBigInts(encryptedMessageAsInts);
		
		// write ciphertext to file
		try {
			new SimpleFile("ciphertext.txt").write(cipherText);
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
		
		System.out.println("Message encrypted successfully.");
	}

}
