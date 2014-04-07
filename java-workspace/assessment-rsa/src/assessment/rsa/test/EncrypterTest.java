package assessment.rsa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import assessment.rsa.Encrypter;

public class EncrypterTest {

	@Test
	public void test() {
		Encrypter e = new Encrypter();
		assertEquals(e.getFoo(), "foo");
	}

}
