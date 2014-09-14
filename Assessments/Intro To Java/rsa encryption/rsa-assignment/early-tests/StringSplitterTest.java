package assessment.rsa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import assessment.rsa.StringSplitter;

public class StringSplitterTest {
	
	@Test
	public void splitTest() {
		StringSplitter s = new StringSplitter();
		
		assertArrayEquals(new String[] {"abc", "def", "ghi"}, s.splitAtInterval("abcdefghi", 3));
	}
	
	@Test
	public void splitUnevenTest() {
		StringSplitter s = new StringSplitter();
		
		assertArrayEquals(new String[] {"abcde", "fghi" }, s.splitAtInterval("abcdefghi", 5));
	}
	
	@Test
	public void splitEmptyTest() {
		StringSplitter s = new StringSplitter();
		
		assertArrayEquals(new String[] {}, s.splitAtInterval("", 5));
	}
}
