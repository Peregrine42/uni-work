package assessment.string;

public class StringOperations {

	public static String[] splitAtInterval(String M, int chunkSize) {
		if (M.isEmpty()) {
			return new String[0];
		}
		
		if (M.length() <= chunkSize) {
			String[] result = { M };
			return result;
		}
		
		int amountOfChunks = (M.length()/chunkSize);
		
		if (M.length() % chunkSize != 0) {
			amountOfChunks += 1;
		}

		String[] result = new String[amountOfChunks];
		
		String buffer = "";
		int arrayCounter = 0;
		for (int i = 0; i < M.length(); i++) {
			buffer += M.charAt(i);
			
			if (buffer.length() == chunkSize) {
				result[arrayCounter] = buffer;
				arrayCounter += 1;
				buffer = "";
			}
		}
		
		if (!buffer.equals("")) {
			result[arrayCounter] = buffer;
		}
		
		return result;
	}
	
}
