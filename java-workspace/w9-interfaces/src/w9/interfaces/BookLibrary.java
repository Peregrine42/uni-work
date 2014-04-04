package w9.interfaces;

import java.util.Collections;

public class BookLibrary extends Library {
	
	public void sortByAuthor() {
		Collections.sort(media, new labelComparator("author"));
	}

}
