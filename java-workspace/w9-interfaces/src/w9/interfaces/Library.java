package w9.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Library {
	
	public ArrayList<Media> media;
	
	Library() {
		this.media = new ArrayList<Media>();
	}
	
	public ArrayList<Media> getByLabel(String target, String label) {
		ArrayList<Media> result = new ArrayList<Media>();
		for (int i = 0; i < media.size(); i++) {
			Media book = media.get(i);
			if (book.getSearchableField(label).contains(target)) {
				result.add(book);
			}
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		
		for (int i = 0; i < media.size(); i++) {
			Media book = media.get(i);
			result += book.toString() + "\n";
		}
		
		return result;
	}
	
	public void sortByFormat() {
		Collections.sort(media, new labelComparator("format"));
	}
	
	public void sortByTitle() {
		Collections.sort(media, new labelComparator("title"));
	}
	
	public void sortByPrice() {
		Collections.sort(media, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				double price1 = ((Media) o1).getPrice();
				double price2 = ((Media) o2).getPrice();
				int comp = Double.compare(price1, price2);
				return comp;
			}
			
		});
	}
	
	public static String resultToString(ArrayList<Media> a) {
		String result = "";
		for (int i = 0; i < a.size(); i++) {
			Object o = a.get(i);
			result += o.toString() + "\n";
		}
		return result;
	}
	
}