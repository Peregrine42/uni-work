package assessment.rsa;

public class LongEncrypter {

	public String encrypt(String message, PublicKey key) {
		Encoding encoding = new Unicode();
		
		Encrypter e = new Encrypter(key, encoding);
		
		int sectionLength = 5;
		RegularStringSections cipherTextParts = new RegularStringSections(message, e, sectionLength);
		
		String seperator = "\n";
		String cipherText = cipherTextParts.makeString(seperator);
		
		return cipherText;
	}
	
}
