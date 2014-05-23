package assessment.rsa.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.math.BigInteger;

import assessment.rsa.Decrypter;
import assessment.rsa.Encrypter;
import assessment.rsa.KeyGenerator;
import assessment.rsa.StringManipulator;

public class IntegrationTest {

	@Test
	public void integrationTest() {
		String message = "hello, how are you today? ф! this is a much longer message but it should cope";
		
		KeyGenerator keygen = new KeyGenerator(512);
		StringManipulator manipulator = new StringManipulator(30);
		
		BigInteger[] messageAsInts = manipulator.convertToUnicodeInts(message);
		
		Encrypter enc = new Encrypter();
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts, keygen.getPublicKey());
		
		String cipherText = manipulator.concatenateBigInts(encryptedMessageAsInts);
		
		BigInteger[] cipherTextAsInts = manipulator.parseCipherText(cipherText);
		
		Decrypter dec = new Decrypter();
		BigInteger[] decryptedTextAsInts = dec.decrypt(cipherTextAsInts, keygen.getPrivateKey());
		
		String decryptedMessage = manipulator.convertToUnicodeString(decryptedTextAsInts);
		
		assertEquals(message, decryptedMessage);
	}
	
}
