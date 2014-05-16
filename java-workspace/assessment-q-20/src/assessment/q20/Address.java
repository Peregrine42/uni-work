package assessment.q20;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Address {
	
	private String firstName;
	private String surname;
	private String emailAddress;
	private Date dateOfBirth;
	
	public Address() {
		this.firstName = "";
		this.surname = "";
		this.emailAddress = "";
		this.dateOfBirth = new Date();
	}
	
	public String toString() {
		String result = "";
		result += firstName + " ";
		result += surname + "\n";
		result += emailAddress + "\n";
		result += new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth);
		return result;
	}
	
	public String getByField(String field) {
		switch (field) {
			case "surname": return getSurname();
			case "emailAddress": return getEmailAddress();
		}
		return "";	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getFullName() {
		return firstName + " " + surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) throws EmailAddressInvalidException {
		if (!emailAddressValid(emailAddress)) {
			throw new EmailAddressInvalidException();
		}
		this.emailAddress = emailAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public static boolean emailAddressValid(String address) {
		return address.matches("^([\\w]+\\.)*([\\w])+@([\\w]+\\.)*[\\w]+");
	}
}