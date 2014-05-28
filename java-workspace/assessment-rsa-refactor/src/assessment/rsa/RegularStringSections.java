package assessment.rsa;

public class RegularStringSections extends StringSections {

	private int chunkSize;

	public RegularStringSections(String string, StringTransformer t, int chunkSize) {
		super(string, t);
		this.chunkSize = chunkSize;
	}
	
	public String[] split(String M) {
		
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
