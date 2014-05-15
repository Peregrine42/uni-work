package assessment.q20.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import assessment.q20.Address;
import assessment.q20.EmailAddressInvalidException;

public class AddressTest {

	@Test
	public void validEmailTest() throws EmailAddressInvalidException {
		Address a = new Address();
		a.setEmailAddress("duncan.fermor@gmail.com");
		assertTrue(true);
	}
	
	@Test(expected=EmailAddressInvalidException.class)
	public void invalidEmailTest1() throws EmailAddressInvalidException {
		Address a = new Address();
		a.setEmailAddress("duncan..fermor@gmail.com");
		assertTrue(false);
	}
	
	@Test(expected=EmailAddressInvalidException.class)
	public void invalidEmailTest2() throws EmailAddressInvalidException {
		Address a = new Address();
		a.setEmailAddress("dun,can.fermor@gmail.com");
		assertTrue(false);
	}
	
	@Test(expected=EmailAddressInvalidException.class)
	public void invalidEmailTest3() throws EmailAddressInvalidException {
		Address a = new Address();
		a.setEmailAddress(".duncan.fermor@gmail.com");
		assertTrue(false);
	}
	
}
