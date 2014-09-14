package assessment.longstrings;


public abstract class OperationOverString {

	/**
	 * class that encapsulates the process
	 * of splitting a string up, performing an
	 * operation on it, then joining it back
	 * together using a joining delimiter
	 **/
	
	String message;
	StringOperation transformer;
	
	public OperationOverString(String message, StringOperation t) {
		this.message = message;
		this.transformer = t;
	}

	public abstract String[] split();
	
	public String makeString() {
		return makeString("");
	}
	
	public String makeString(String joiner) {
		String[] parts = split();
		
		String output = "";
		
		for (int i = 0; i < parts.length; i++) {
			output += transformer.stringTransform(parts[i]);
			
			// only add a joiner if this is not 
			// the last element
			if (i < (parts.length - 1)) {
				output += joiner;
			}
		}
		
		return output;
	}
	
}