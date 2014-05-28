package assessment.rsa;

public class LongDecrypter {

	private Decrypter decrypter;
	
	public LongDecrypter(Decrypter decrypter) {
		super();
		this.decrypter = decrypter;
	}
	
	public String decrypt(String message) {
		String decryptedMessage = "";
		for (String section : decryptedMessage.split(" ")) {
			decryptedMessage += decrypter.decrypt(section);
		}
		
		return decryptedMessage;
	}
	
}
