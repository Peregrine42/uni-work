package assessment.q20;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddressBook {

	private ArrayList<Address> addresses;
	
	public AddressBook() {
		addresses = new ArrayList<Address>();
	}
	
	public void add(Address a) {
		addresses.add(a);
	}
	
	public void remove(Address a) {
		addresses.remove(a);
	}
	
	public String displayAddresses(ArrayList<Address> a) {
		String result = "";
		for (Address address : a) {
			result += address.toString();
			result += "\n\n";
		}
		return result;
	}
	
	public ArrayList<Address> getAddressesFromField(String term, String field) {
		ArrayList<Address> result = new ArrayList<Address>();
		for (Address a : addresses) {
			if (a.getByField(field).equals(term)) {
				result.add(a);
			}
		}
		return result;
	}
	
	public ArrayList<Address> getAddressesFromSurname(String surname) {
		return getAddressesFromField(surname, "surname");
	}
	
	public ArrayList<Address> getAddressesFromEmailAddress(String address) {
		return getAddressesFromField(address, "emailAddress");
	}
	
	public ArrayList<Address> getAddressesFromDateOfBirth(Date date) {
		ArrayList<Address> result = new ArrayList<Address>();
		for (Address a : addresses) {
			if (a.getDateOfBirth().equals(date)) {
				result.add(a);
			}
		}
		return result;
	}
	
	public ArrayList<Address> sort() {
		ArrayList<Address> result = new ArrayList<Address>(addresses);
		Collections.sort(result, new dateComparator());
		return result;
	}

	class dateComparator implements Comparator<Address> {
		@Override
	    public int compare(Address a1, Address a2) {
			Date d1 = a1.getDateOfBirth();
			int d1_month = getMonth(d1);
			int d1_day = getDay(d1);
			
			Date d2 = a2.getDateOfBirth();
			int d2_month = getMonth(d2);
			int d2_day = getDay(d2);
			
			return compareMonths(d1_month, d2_month, d1_day, d2_day);
	    }
		
		private int compareMonths(int d1_month, 
				                  int d2_month, 
				                  int d1_day,
				                  int d2_day) {
			if (d1_month > d2_month) {
				return 1;
			} else if (d1_month < d2_month) {
				return -1;
			} else {
				return compareInts(d1_day, d2_day);
			}
		}
		
		private int getDay(Date d) {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(d);			
			return cal.get(Calendar.DAY_OF_MONTH);
		}
		
		private int getMonth(Date d) {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(d);
			return cal.get(Calendar.MONTH);
		}
		
		private int compareInts(int a, int b) {
			if (a > b) {
				return 1;
			} else if (a < b) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}