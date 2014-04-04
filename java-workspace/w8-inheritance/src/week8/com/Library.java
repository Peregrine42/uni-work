package week8.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Library {
	
	public ArrayList<Book> books;
	
	Library() {
		this.books = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getByLabel(String target, String label) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getSearchableField(label).contains(target)) {
				result.add(book);
			}
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			result += book.toString() + "\n";
		}
		
		return result;
	}
	
	public void sortByAuthor() {
		Collections.sort(books, new labelComparator("author"));
	}
	
	public void sortByFormat() {
		Collections.sort(books, new labelComparator("format"));
	}
	
	public void sortByTitle() {
		Collections.sort(books, new labelComparator("title"));
	}
	
	public void sortByPrice() {
		Collections.sort(books, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				double price1 = ((Book) o1).price;
				double price2 = ((Book) o2).price;
				int comp = Double.compare(price1, price2);
				return comp;
			}
			
		});
	}
	
	public static String resultToString(ArrayList<Book> a) {
		String result = "";
		for (int i = 0; i < a.size(); i++) {
			Object o = a.get(i);
			result += o.toString() + "\n";
		}
		return result;
	}
	
}