package assessment.q20.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import assessment.q20.Address;
import assessment.q20.EmailAddressInvalidException;

public class AddressTest {

	@Test
	public void toStringTest() throws EmailAddressInvalidException, ParseException {
		Address a = new Address();
		a.setFirstName("Duncan");
		a.setSurname("Fermor");
		a.setEmailAddress("duncan.fermor@gmail.com");
		
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse("22/03/1989");
		a.setDateOfBirth(d);
		String result = "Duncan Fermor\nduncan.fermor@gmail.com\n22/03/1989";
		assertEquals(result, a.toString());
	}
	
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
