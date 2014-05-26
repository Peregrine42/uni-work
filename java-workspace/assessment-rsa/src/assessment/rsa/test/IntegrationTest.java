package assessment.rsa.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import assessment.rsa.Decrypter;
import assessment.rsa.Encrypter;
import assessment.rsa.SimpleFile;
import assessment.rsa.KeyGenerator;
import assessment.rsa.PrivateKey;
import assessment.rsa.PublicKey;
import assessment.rsa.StringParser;

public class IntegrationTest {

	KeyGenerator keygen;
	StringParser parser;
	
	@Before
	public void setup() {
		keygen = new KeyGenerator(512);
		parser = new StringParser(30);
	}
	
	@Test
	public void integrationTest() {
		String message = "hello, how are you today? ф! this is a much longer message but we should be able to cope";
		
		String cipherText = encryptString(message, keygen.getPublicKey());
		String decryptedMessage = decryptString(cipherText, keygen.getPrivateKey());
		
		assertEquals(message, decryptedMessage);
	}
	
	public String encryptString(String message, PublicKey key) {
		Encrypter enc = new Encrypter(key);
		
		BigInteger[] messageAsInts = parser.convertToUnicodeInts(message);
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts);
		return parser.concatenateBigInts(encryptedMessageAsInts);
	}
	
	public String decryptString(String cipherText, PrivateKey key) {
		Decrypter dec = new Decrypter(key);
		
		BigInteger[] cipherTextAsInts = parser.parseCipherText(cipherText);
		BigInteger[] decryptedTextAsInts = dec.decrypt(cipherTextAsInts);
		
		return parser.convertToUnicodeString(decryptedTextAsInts);
	}
	
	@Test
	public void integrationFromFileTest() throws IOException {
		String theOriginalMessage = "ʢՈ ܓLorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt\n ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit\n esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt\n mollit anim id est laborum.";
		
		// write our test string to a file ready to be read in
		SimpleFile inputFile = new SimpleFile("output", "integration", "input");
		inputFile.write(theOriginalMessage);
		
		new SimpleFile("output", "integration", "public.key").write(keygen.getPublicKey().toString());
		new SimpleFile("output", "integration", "private.key").write(keygen.getPrivateKey().toString());
		
		// encrypt
		// read in the public key
		String publicKeyString = new SimpleFile("output", "integration", "public.key").read();
		
		// read in the message
		String messageFromFile = new SimpleFile("output", "integration", "input").read();
		
		// encrypt the message
		String cipherText = encryptString(messageFromFile, new PublicKey(publicKeyString));
		
		// write ciphertext to file
		new SimpleFile("output", "integration", "ciphertext").write(cipherText);
		
		
		//decrypt
		// read in the private key
		String privateKeyString = new SimpleFile("output", "integration", "private.key").read();
		
		// read in the cipher text
		String cipherTextFromFile = new SimpleFile("output", "integration", "ciphertext").read();
		
		// decrypt the cipher text
		String decryptedMessage = decryptString(cipherTextFromFile, new PrivateKey(privateKeyString));
		
		// output
		assertEquals(theOriginalMessage, decryptedMessage);
		
	}
	
}
