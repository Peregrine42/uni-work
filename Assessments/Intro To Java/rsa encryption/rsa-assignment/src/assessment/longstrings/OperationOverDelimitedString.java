package assessment.longstrings;

public class OperationOverDelimitedString extends OperationOverString {

	/**
	 * splits a string along a delimiter,
	 * such as space
	 **/
	
	private String delimiter;

	public OperationOverDelimitedString(String message, StringOperation operation, String delimiter) {
		super(message, operation);
		this.delimiter = delimiter;
	}
	
	public String[] split() {
		return message.split(delimiter);
	}
	
}
