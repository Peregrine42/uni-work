package assessment.rsa;

import java.io.IOException;

public class KeyGeneratorCLI {

	public static void main(String[] args) {
		
		// assume the first argument is a destination path
		String path = "";
		if (args.length == 0) {
		} else {
			path = args[0];
		}
		
		try {
			KeyGenerator keygen = new KeyGenerator(512);
			new SimpleFile(path, "public.key").write(keygen.getPublicKey().toString());
			new SimpleFile(path, "private.key").write(keygen.getPrivateKey().toString());
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
		
		System.out.println("Key generation complete.");
	}

}
