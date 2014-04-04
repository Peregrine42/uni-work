package week8.com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class week8 {

	public static void main(String[] args) {
		
	}
	
	public static void one() {
		Library l = new Library();
		l.books.add(new Book("Bloggs", "Alpha Title", 3.99, "paperback"));
		l.books.add(new Book("Catherine", "K Title", 1.99, "hardback"));
		l.books.add(new Book("Gerald", "B Title", 4.99, "hardback"));
		
		l.sortByAuthor();
		System.out.println("Sorted by Author:");
		System.out.println(l);
		
		l.sortByTitle();
		System.out.println("Sorted by Title:");
		System.out.println(l);
		
		l.sortByPrice();
		System.out.println("Sorted by Price:");
		System.out.println(l);
		
		System.out.println("All hardbacks:");
		System.out.println(Library.resultToString(l.getByLabel("hardback", "format")));
	}
}

class Date {
	int day;
	int month;
	int year;
	int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30 };
	
	Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	
}

class Book {
	
	public String author;
	public String title;
	public double price;
	public String format;
	
	Book(String author,
		 String title,
		 double price,
		 String format) {
		
		this.author = author;
		this.title = title;
		this.price = price;
		this.format = format;
		
	}
	
	public String toString() {
		return title + " by " + author + " (" + format + ", priced: " + price + ")";
	}
	
	public String getSearchableField(String label) {
		if (label.equals("author")) {
			return this.author;
		} else {
			if (label.equals("format")) {
				return this.format;
			}
		};
		return this.title;
	}
	
}

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

class labelComparator implements Comparator<Object> {
	
	String label;
	
	labelComparator(String label) {
		this.label = label;
	}
	
	public int compare(Object o1, Object o2) {
		String title1 = ((Book) o1).getSearchableField(label);
		String title2 = ((Book) o2).getSearchableField(label);
		int comp = title1.compareTo(title2);
		return comp;
	}
}