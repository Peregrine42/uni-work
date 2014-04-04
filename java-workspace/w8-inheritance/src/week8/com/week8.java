package week8.com;


public class week8 {

	public static void main(String[] args) {
		threeA();
	}
	
	public static void threeA() {
		
		int b = 2;
		int i = 3;
		int m = 4;
		
		Linear l    = new Linear(b, i);
		Quadratic q = new Quadratic(b, m);
		
		int amount = 10;
		
		int[] totals = new int[amount];
		int[] totals2 = new int[amount];
		for (int j = 0; j < amount ; j++) {
			totals[j]  = l.generate(j);
			totals2[j] = q.generate(j);
		}
		
		for (int j = 0; j < amount ; j++) {
			System.out.println(totals[j]);
		}
		
		System.out.println();
		
		for (int j = 0; j < amount ; j++) {
			System.out.println((int) totals2[j]);
		}
	}
	
	public static void two() {
		Date d = new Date(2, 1, 2013);
		System.out.println(d.dayOfTheWeek());
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

interface Sequence {
	public int generate(int i);
}

class Linear implements Sequence {
	int a;
	int b;
	
	Linear(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int generate(int i) {
		return a + (b * i);
	}
}

class Quadratic implements Sequence {
	int a;
	int b;
	
	Quadratic(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int generate(int i) {
		return (int) (a + (Math.pow(b, i)));
	}
}

class Date {
	int day;
	int month;
	int year;
	            //jan feb mar  apr may jun jul aug sep oct nov dec
	int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	String[] dayLabels = { "monday", 
			               "tuesday",
			               "wednesday",
			               "thursday",
			               "friday",
			               "saturday",
			               "sunday" };
	
	int dayOffset = 1;
	
	Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	public int daysSinceStartOfYear() {
		int total = 0;
		
		for (int i = 0; i < month - 1; i++) {
			total += days[month];
		}
		
		total += day;
		
		total -= 1;
		return total;
	}
	
	public String dayOfTheWeek() {
		return dayLabels[(daysSinceStartOfYear() % 7) + dayOffset];
	}
	
	
}