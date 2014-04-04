package w9.interfaces;

import java.util.Scanner;

public class Week9 {

	public static void main(String[] args) {
		two();
	}
	
	public static void two() {
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
	
	public static void one() {
		Scanner input = new Scanner(System.in);
		Shape s = new Shape();
		boolean invalidChoice = true;
		while (invalidChoice == true) {
			System.out.print("Which shape? ");
			String choice = input.next();
			switch (choice) {
			case "t":
				s = new Triangle(input);
				invalidChoice = false;
				break;
			case "s":
				s = new Square(input);
				invalidChoice = false;
				break;
			case "c":
				s = new Circle(input);
				invalidChoice = false;
				break;
			case "r":
				s = new Rectangle(input);
				invalidChoice = false;
				break;
			default:
				System.out.println("Unexpected letter. Please enter t, s, c or r");
				break;
			}
		}
		
		System.out.printf("Area of shape: %.4f\n", s.area());
		System.out.printf("Perimeter of shape: %.4f", s.perimeter());
	}
	
	public static double getDouble(Scanner s, String message) {
		System.out.print(message + " ");
		double d = s.nextDouble();
		return d;
	}
}


