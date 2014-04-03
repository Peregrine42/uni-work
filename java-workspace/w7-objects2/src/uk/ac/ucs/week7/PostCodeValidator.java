package uk.ac.ucs.week7;

class PostCodeValidator {
	
	public static boolean valid(String s) {
		return s.toLowerCase().matches("[a-z]{1,2}[0-9]{1,2} [0-9][a-z]{2}");
	}
	
}