package assessment.rsa.test;

import java.math.BigInteger;

import org.junit.Test;

import assessment.rsa.Encrypter;
import assessment.rsa.KeyGenerator;
import assessment.rsa.StringManipulator;

public class IntegrationTest {

	@Test
	public void integrationTest() {
		String message = "hello, how are you today? ф!";
		
		KeyGenerator keygen = new KeyGenerator();
		StringManipulator manipulator = new StringManipulator();
		
		BigInteger[] messageAsInts = manipulator.convertToUnicodeInts(message);
		
		Encrypter enc = new Encrypter();
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts, keygen.getPublicKey());
		
		Encrypter dec = new Encrypter();
		BigInteger[] encryptedMessageAsInts = enc.encrypt(messageAsInts, keygen.getPublicKey());
	}
	
}
