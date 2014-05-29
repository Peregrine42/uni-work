package assessment.longstrings;

import assessment.string.StringOperations;

public class OperationOverModularString extends OperationOverString {

	private int chunkSize;

	public OperationOverModularString(String string, StringOperation t, int chunkSize) {
		super(string, t);
		this.chunkSize = chunkSize;
	}
	
	public String[] split() {
		return StringOperations.splitAtInterval(message, chunkSize);
	}
	
}
