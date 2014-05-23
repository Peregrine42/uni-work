package assessment.rsa.test;
import java.io.IOException;

import assessment.rsa.FileLibrary;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileLibraryTest {

	@Test
	public void readTest() throws IOException {
		FileLibrary f = new FileLibrary("public_key");
		
		assertEquals("test\nstring", f.read());
	}
	
	@Test
	public void writeTest() throws IOException {
		FileLibrary f = new FileLibrary("new_file");
		
		f.write("hello\n everybody!");
		assertEquals("hello\n everybody!", f.read());
	}
}