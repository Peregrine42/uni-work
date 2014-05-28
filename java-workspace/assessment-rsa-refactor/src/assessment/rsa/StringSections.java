package assessment.rsa;

public class StringSections {

	// splits a string up, processes it,
	// joins it up
	
	private String string;
	private StringTransformer transformer;
	
	public StringSections(String string, StringTransformer t) {
		this.string = string;
		this.transformer = t;
	}

	public String[] split() {
		return string.split(" ");
	}
	
	public String process() {
		String[] parts = split();
		
		String output = "";
		
		for (String section : parts) {
			output += transformer.stringTransform(section);
		}
		
		return output;
	}
	
}
