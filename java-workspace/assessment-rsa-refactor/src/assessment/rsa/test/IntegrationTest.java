package assessment.rsa.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import assessment.rsa.CipherText;
import assessment.rsa.KeyGenerator;
import assessment.rsa.PlainText;
import assessment.rsa.UnicodePlainText;

public class IntegrationTest {

	KeyGenerator keygen;
	
	@Before
	public void setup() {
		keygen = new KeyGenerator(512);
	}
	
	@Test
	public void firstIntegrationTest() {
		String message = "hello!";
		
		CipherText C = keygen.getPublicKey().encrypt(new UnicodePlainText(message));
		PlainText M = keygen.getPrivateKey().decrypt(C);
		
		assertEquals(message, M.toString());
	}
	
}