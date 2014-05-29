package assessment.rsa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleFile {
	
	Path path;
	
	public SimpleFile(String... filenames) {
		Path currentRelativePath = Paths.get("");
		this.path = currentRelativePath.toAbsolutePath();
		for (String s : filenames) {
			// if (s.isEmpty()) { continue; }
			this.path = this.path.resolve(s);
		}
	}
	
	public String read() throws IOException {
		/**
		 * reads the contents of a file, stripping
		 * any type of carriage return or line feed
		 * and replacing it with single line feeds
		 * 
		 * useful:
		 * http://illegalargumentexception.blogspot.co.uk/2009/05/java-rough-guide-to-character-encoding.html#javaencoding_streams
		 */
		
		FileInputStream input = null;
		InputStreamReader reader = null;
		StringBuilder s;
		try {
			input = new FileInputStream(path.toFile());
			reader = new InputStreamReader(input, "UTF-8");
			s = new StringBuilder();

			BufferedReader b = new BufferedReader(reader);
			
			int lineCount = 0;
		    while (true) {
		    	lineCount += 1;
		        
		        String line = b.readLine();
			    if (line == null) {
			    	break;
			    }
			    
			    if (lineCount > 1) {
			    	s.append('\n');
			    }
			    s.append(line);
		    } 
		} finally {
			if (reader != null) {
				reader.close();
            }
		}
        return s.toString();
	}

	public void write(String string) throws IOException {
		/**
		 * writes a string to file
		 */
		
		FileOutputStream output = null;
		OutputStreamWriter writer = null;
		try {
			output = new FileOutputStream(path.toFile());
			writer = new OutputStreamWriter(output, "UTF-8");
			writer.write(string);
		} finally {
			if (writer != null) {
				writer.close();
            }
		}
	}
}
