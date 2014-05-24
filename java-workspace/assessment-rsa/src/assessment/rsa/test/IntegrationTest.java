package assessment.rsa.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.Test;

import assessment.rsa.Decrypter;
import assessment.rsa.Encrypter;
import assessment.rsa.File;
import assessment.rsa.KeyGenerator;
import assessment.rsa.PrivateKey;
import assessment.rsa.PublicKey;
import assessment.rsa.StringManipulator;

public class IntegrationTest {

	@Test
	public void integrationTest() {
		String message = "hello, how are you today? ф! this is a much longer message but we should be able to cope";
		
		KeyGenerator keygen = new KeyGenerator(512);
		StringManipulator manipulator = new StringManipulator(30);
		
		BigInteger[] messageAsInts = manipulator.convertToUnicodeInts(message);
		
		Encrypter enc = new Encrypter(keygen.getPublicKey());
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts);
		
		String cipherText = manipulator.concatenateBigInts(encryptedMessageAsInts);
		
		BigInteger[] cipherTextAsInts = manipulator.parseCipherText(cipherText);
		
		Decrypter dec = new Decrypter(keygen.getPrivateKey());
		BigInteger[] decryptedTextAsInts = dec.decrypt(cipherTextAsInts);
		
		String decryptedMessage = manipulator.convertToUnicodeString(decryptedTextAsInts);
		
		assertEquals(message, decryptedMessage);
	}
	
	@Test
	public void integrationFromFileTest() throws IOException {
		String theOriginalMessage = "ʢՈ ܓLorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt\n ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit\n esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt\n mollit anim id est laborum.";
		
		// write our test string to a file ready to be read in
		File inputFile = new File("output", "integration", "input");
		inputFile.write(theOriginalMessage);
		
		// keygen
		// generate keys and write them to files
		KeyGenerator keygen = new KeyGenerator(64);
		
		new File("output", "integration", "public.key").write(keygen.getPublicKey().toString());
		new File("output", "integration", "private.key").write(keygen.getPrivateKey().toString());
		
		// encrypter
		// read in the public key
		String publicKeyString = new File("output", "integration", "public.key").read();
		
		// read in the message
		String messageFromFile = new File("output", "integration", "input").read();
		
		// encrypt the message
		StringManipulator manipulator = new StringManipulator(5);
		BigInteger[] messageAsInts = manipulator.convertToUnicodeInts(messageFromFile);
		Encrypter enc = new Encrypter(new PublicKey(publicKeyString));
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts);
		String cipherText = manipulator.concatenateBigInts(encryptedMessageAsInts);
		
		// write ciphertext to file
		new File("output", "integration", "ciphertext").write(cipherText);
		
		
		//decrypter
		// read in the private key
		String privateKeyString = new File("output", "integration", "private.key").read();
		
		// read in the cipher text
		String cipherTextFromFile = new File("output", "integration", "ciphertext").read();
		
		// decrypt the cipher text
		BigInteger[] cipherTextAsInts = manipulator.parseCipherText(cipherTextFromFile);
		Decrypter dec = new Decrypter(new PrivateKey(privateKeyString));
		BigInteger[] decryptedTextAsInts = dec.decrypt(cipherTextAsInts);
		String decryptedMessage = manipulator.convertToUnicodeString(decryptedTextAsInts);
		
		// output
		System.out.println(decryptedMessage);
		assertEquals(theOriginalMessage, decryptedMessage);
		
	}
	
}
