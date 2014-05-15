package assessment.q20.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import assessment.q20.Address;
import assessment.q20.AddressBook;
import assessment.q20.EmailAddressInvalidException;

public class AddressBookTest {
	
	@Test
	public void addressBySurnameTest() {
		AddressBook a = new AddressBook();
		
		Address a1 = new Address();
		a1.setSurname("Fermor");
		a.add(a1);
		
		Address a2 = new Address();
		a2.setSurname("Fermor");
		a.add(a2);
		
		Address a3 = new Address();
		a3.setSurname("Muir");
		a.add(a3);
		
		ArrayList<Address> r = new ArrayList<Address>();
		r.add(a1);
		r.add(a2);
		
		assertEquals(r, a.getAddressesFromSurname("Fermor"));
	}
	
	@Test
	public void addressByEmailTest() throws EmailAddressInvalidException {
		AddressBook a = new AddressBook();
		
		Address a1 = new Address();
		a1.setEmailAddress("test@example.com");
		a.add(a1);
		
		Address a2 = new Address();
		a2.setEmailAddress("test@example.com");
		a.add(a2);
		
		Address a3 = new Address();
		a3.setEmailAddress("miss@example.com");
		a.add(a3);
		
		ArrayList<Address> r = new ArrayList<Address>();
		r.add(a1);
		r.add(a2);
		
		assertEquals(r, a.getAddressesFromEmailAddress("test@example.com"));
	}
	
	@Test
	public void addressByBirthdayTest() {
		AddressBook a = new AddressBook();
		
		GregorianCalendar c = new GregorianCalendar();
		c.set(22, 3, 1989);
		Date targetDate = c.getTime();
		c.set(22, 3, 1990);
		Date anotherDate = c.getTime();
		
		Address a1 = new Address();
		a1.setDateOfBirth(targetDate);
		a.add(a1);
		
		Address a2 = new Address();
		a2.setDateOfBirth(targetDate);
		a.add(a2);
		
		Address a3 = new Address();
		a3.setDateOfBirth(anotherDate);
		a.add(a3);
		
		ArrayList<Address> r = new ArrayList<Address>();
		r.add(a1);
		r.add(a2);
		
		assertEquals(r, a.getAddressesFromDateOfBirth(targetDate));
	}
	
	@Test
	public void sortTest() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(22, 3, 1989);
		Date first = c.getTime();
		
		c.set(23, 3, 1991);
		Date second = c.getTime();
		
		c.set(01, 5, 1995);
		Date third = c.getTime();
		
		AddressBook a = new AddressBook();
		
		Address a1 = new Address();
		a1.setDateOfBirth(second);
		a.add(a1);
		
		Address a2 = new Address();
		a2.setDateOfBirth(first);
		a.add(a2);
		
		Address a3 = new Address();
		a3.setDateOfBirth(third);
		a.add(a3);
		
		ArrayList<Address> r = new ArrayList<Address>();
		r.add(a2);
		r.add(a1);
		r.add(a3);
		
		assertEquals(r, a.sort());
	}
	
}