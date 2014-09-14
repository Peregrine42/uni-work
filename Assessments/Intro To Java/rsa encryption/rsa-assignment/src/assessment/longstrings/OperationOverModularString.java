package assessment.longstrings;

import assessment.string.StringLibrary;

public class OperationOverModularString extends OperationOverString {

	/**
	 * splits a string at regular intervals -
	 * a sort of modular operation for strings
	 **/
	
	private int chunkSize;

	public OperationOverModularString(String string, StringOperation t, int chunkSize) {
		super(string, t);
		this.chunkSize = chunkSize;
	}
	
	public String[] split() {
		return StringLibrary.splitAtInterval(message, chunkSize);
	}
	
}
