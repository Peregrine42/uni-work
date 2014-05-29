package assessment.rsa;

public class RegularStringSections extends StringSections {

	private int chunkSize;

	public RegularStringSections(String string, StringTransformer t, int chunkSize) {
		super(string, t);
		this.chunkSize = chunkSize;
	}
	
	public String[] split() {
		
		if (message.isEmpty()) {
			return new String[0];
		}
		
		if (message.length() <= chunkSize) {
			String[] result = { message };
			return result;
		}
		
		int amountOfChunks = (message.length()/chunkSize);
		
		if (message.length() % chunkSize != 0) {
			amountOfChunks += 1;
		}

		String[] result = new String[amountOfChunks];
		
		String buffer = "";
		int arrayCounter = 0;
		for (int i = 0; i < message.length(); i++) {
			buffer += message.charAt(i);
			
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
