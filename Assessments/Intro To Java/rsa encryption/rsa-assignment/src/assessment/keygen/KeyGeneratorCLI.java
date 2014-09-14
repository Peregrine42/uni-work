package assessment.keygen;

import java.io.IOException;
import assessment.file.SimpleFile;

public class KeyGeneratorCLI {

	/**
	 * entry point for the keygen command
	 * line program.
	 * 
	 * command line arguments:
	 * key destination directory (relative), default: current directory
	 **/
	
	public static void main(String[] args) {
		
		// handle arguments
		String path = "";
		if (args.length == 0) {
		} else {
			path = args[0];
		}
		
		// generate keys
		KeyGenerator keygen = new KeyGenerator(512);
		
		// write keys
		try {
			new SimpleFile(path, "public.key").write(keygen.getPublicKey().toString());
			new SimpleFile(path, "private.key").write(keygen.getPrivateKey().toString());
		} catch (IOException e) {
			System.out.println("Path not found.\n" + e.getMessage());
			return;
		}
		
		// log completion message
		System.out.println("Key generation complete.");
	}
}
