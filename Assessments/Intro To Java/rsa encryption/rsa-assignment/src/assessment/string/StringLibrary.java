package assessment.string;

public class StringLibrary {

	/**
	 * Library class used in:
	 * 	OperationOverModularString
	 *  UnicodePlainText
	 **/
	
	public static String[] splitAtInterval(String M, int chunkSize) {
		// guard against empty strings
		if (M.isEmpty()) {
			return new String[0];
		}
		
		// guard against strings that
		// are smaller than the chunk size
		if (M.length() <= chunkSize) {
			String[] result = { M };
			return result;
		}
		
		// calculate size of array
		int amountOfChunks = (M.length()/chunkSize);
		if (M.length() % chunkSize != 0) {
			amountOfChunks += 1;
		}

		String[] result = new String[amountOfChunks];
		
		String buffer = "";
		int arrayCounter = 0;
		for (int i = 0; i < M.length(); i++) {
			buffer += M.charAt(i);
			
			// populate array when buffer is full
			if (buffer.length() == chunkSize) {
				result[arrayCounter] = buffer;
				arrayCounter += 1;
				buffer = "";
			}
		}
		
		// empty buffer
		if (!buffer.isEmpty()) {
			result[arrayCounter] = buffer;
		}
		
		return result;
	}
	
}
