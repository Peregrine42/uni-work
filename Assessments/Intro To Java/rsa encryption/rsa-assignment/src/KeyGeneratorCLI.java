package assessment.rsa;

import java.io.IOException;

public class KeyGeneratorCLI {

	public static void main(String[] args) throws IOException {
		
		// assume the first argument is a destination path
		String path;
		if (args.length == 0) {
			path = "";
		} else {
			path = args[0];
		}
		
		KeyGenerator keygen = new KeyGenerator(512);
		new SimpleFile(path, "public.key").write(keygen.getPublicKey().toString());
		new SimpleFile(path, "private.key").write(keygen.getPrivateKey().toString());
	}

}
