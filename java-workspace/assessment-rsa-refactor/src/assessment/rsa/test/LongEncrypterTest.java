package assessment.rsa.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import assessment.rsa.LongEncrypter;
import assessment.rsa.PublicKey;
import assessment.rsa.SimpleFile;

public class LongEncrypterTest {

	@Test
	public void firstTest() throws IOException {
		String publicKeyString = new SimpleFile("public.key").read();
		String inputString = new SimpleFile("input.txt").read();
		
		LongEncrypter e = new LongEncrypter();
		String cipherText = e.encrypt(inputString, new PublicKey(publicKeyString));
		
		new SimpleFile("output.txt").write(cipherText);
		
		assertTrue(true);
	}
	
}
