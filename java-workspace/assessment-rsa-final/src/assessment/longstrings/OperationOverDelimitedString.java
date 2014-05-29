package assessment.longstrings;

public class OperationOverDelimitedString extends OperationOverString {

	private String delimiter;

	public OperationOverDelimitedString(String message, StringOperation t, String delimiter) {
		super(message, t);
		this.delimiter = delimiter;
	}
	
	public String[] split() {
		return message.split(delimiter);
	}
	
}
