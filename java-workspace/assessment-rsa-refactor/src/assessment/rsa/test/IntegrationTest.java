package assessment.rsa.test;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import assessment.rsa.CipherText;
import assessment.rsa.Decrypter;
import assessment.rsa.Encoding;
import assessment.rsa.Encrypter;
import assessment.rsa.KeyGenerator;
import assessment.rsa.PlainText;
import assessment.rsa.RegularStringSections;
import assessment.rsa.StringOperations;
import assessment.rsa.StringSections;
import assessment.rsa.Unicode;

public class IntegrationTest {

	KeyGenerator keygen;
	Encoding encoding = new Unicode();
	
	@Before
	public void setup() {
		keygen = new KeyGenerator(512);
	}
	
	@Test
	public void firstIntegrationTest() {
		String message = "hello!";
		
		BigInteger m = encoding.plainText(message).toBigInteger();
		CipherText C = encoding.cipherText(keygen.getPublicKey().encrypt(m));
		
		BigInteger n = C.toBigInteger();
		PlainText M = encoding.plainText(keygen.getPrivateKey().decrypt(n));
		
		assertEquals(message, M.toString());
	}
	
	@Test
	public void secondIntegrationTest() {
		String message = "hello this is a longer message";
		
		String[] longCipherTextSections = StringOperations.splitAtInterval(message, 5);
		String longCipherText = "";
		for (String section : longCipherTextSections) {
			BigInteger m = encoding.plainText(section).toBigInteger();
			CipherText C = encoding.cipherText(keygen.getPublicKey().encrypt(m));
			
			longCipherText += C.toString() + " ";
		}
		
		longCipherTextSections = null;
		
		longCipherTextSections = longCipherText.split(" ");
		String longMessage = "";
		for (String section : longCipherTextSections) {
			BigInteger n = encoding.cipherText(section).toBigInteger();
			PlainText M = encoding.plainText(keygen.getPrivateKey().decrypt(n));
			
			longMessage += M.toString();
		}
		
		assertEquals(message, longMessage);
	}
	
	@Test
	public void thirdIntegrationTest() {
		String message = "hello this is a longer message";
		
		encoding = new Unicode();
		
		Encrypter e = new Encrypter(keygen.getPublicKey(), encoding);
		
		int sectionLength = 5;
		RegularStringSections cipherTextParts = new RegularStringSections(message, e, sectionLength);
		
		String seperator = " ";
		String cipherText = cipherTextParts.makeString(seperator);
		
		Decrypter d = new Decrypter(keygen.getPrivateKey(), encoding);
		StringSections cipherTextSections = new StringSections(cipherText, d);
		
		seperator = "";
		String longMessage = cipherTextSections.makeString(seperator);
		
		System.out.println("result: " + longMessage);
		assertEquals(message, longMessage);
	}
	
}