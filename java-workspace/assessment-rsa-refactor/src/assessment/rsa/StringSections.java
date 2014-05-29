package assessment.rsa;

public class StringSections {

	// splits a string up, processes it,
	// joins it up
	
	String message;
	StringTransformer transformer;
	
	public StringSections(String message, StringTransformer t) {
		this.message = message;
		this.transformer = t;
	}

	public String[] split() {
		return message.split(" ");
	}
	
	public String makeString(String seperator) {
		String[] parts = split();
		
		String output = "";
		
		for (int i = 0; i < parts.length; i++) {
			//System.out.println(transformer.stringTransform(parts[i]) + seperator);
			output += transformer.stringTransform(parts[i]) + seperator;
		}
		
//		StringBuilder s = new StringBuilder();
//		for (String section : parts) {
//			s.append(transformer.stringTransform(section));
//		}
		
		return output;
	}
	
}
