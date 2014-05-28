package assessment.rsa;

public class StringJoiner {

	private static final String seperator = " ";
	
	public String[] split(String s) {
		return s.split(seperator);
	}
	
	public String append(String body, String part) {
		return body + seperator + part;
	}
	
}
