package assessment.rsa.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import assessment.rsa.SimpleFile;
import assessment.rsa.KeyGenerator;
import assessment.rsa.PrivateKey;
import assessment.rsa.PublicKey;
import assessment.rsa.StringDecrypter;
import assessment.rsa.StringEncrypter;

public class IntegrationTest {

	KeyGenerator keygen;
	
	@Before
	public void setup() {
		keygen = new KeyGenerator(512);
	}
	
	@Test
	public void integrationTest() {
		String message = "hello, how are you today? ф! this is a much longer message but we should be able to cope";
		
		String cipherText = new StringEncrypter(keygen.getPublicKey(), 30).encrypt(message);
		String decryptedMessage = new StringDecrypter(keygen.getPrivateKey()).decrypt(cipherText);
		
		assertEquals(message, decryptedMessage);
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
		String cipherText = new StringEncrypter(new PublicKey(publicKeyString), 30).encrypt(messageFromFile);
		
		// write ciphertext to file
		new SimpleFile("output", "integration", "ciphertext").write(cipherText);
		
		
		//decrypt
		// read in the private key
		String privateKeyString = new SimpleFile("output", "integration", "private.key").read();
		
		// read in the cipher text
		String cipherTextFromFile = new SimpleFile("output", "integration", "ciphertext").read();
		
		// decrypt the cipher text
		String decryptedMessage = new StringDecrypter(new PrivateKey(privateKeyString)).decrypt(cipherTextFromFile);
		
		// output
		assertEquals(theOriginalMessage, decryptedMessage);
		
	}
	
}
