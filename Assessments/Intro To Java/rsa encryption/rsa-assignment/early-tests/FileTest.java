package assessment.rsa.test;
import java.io.IOException;

import assessment.rsa.SimpleFile;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileTest {

	@Test
	public void readTest() throws IOException {
		SimpleFile f = new SimpleFile("output", "file", "test_input");
		
		assertEquals("test\nstring", f.read());
	}
	
	@Test
	public void writeTest() throws IOException {
		SimpleFile f = new SimpleFile("output", "file", "new_file");
		
		f.write("hello\n everybody!");
		assertEquals("hello\n everybody!", f.read());
	}
}