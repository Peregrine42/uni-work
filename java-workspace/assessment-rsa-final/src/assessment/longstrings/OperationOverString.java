package assessment.longstrings;


public abstract class OperationOverString {

	// splits a string up, processes it,
	// joins it up
	
	String message;
	StringOperation transformer;
	
	public OperationOverString(String message, StringOperation t) {
		this.message = message;
		this.transformer = t;
	}

	public abstract String[] split();
	
	public String makeString(String seperator) {
		String[] parts = split();
		
		String output = "";
		
		for (int i = 0; i < parts.length; i++) {
			output += transformer.stringTransform(parts[i]) + seperator;
		}
		return output;
	}
	
}
