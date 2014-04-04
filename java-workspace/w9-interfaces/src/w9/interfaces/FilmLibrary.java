package w9.interfaces;

import java.util.Collections;

public class FilmLibrary extends Library {

	public void sortByDirector() {
		Collections.sort(media, new labelComparator("director"));
	}
	
}
