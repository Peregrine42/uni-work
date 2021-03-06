package week6.com;

import java.util.Scanner;

public class Week6 {

	public static void main(String[] args) {
		
	}
	
	public static void three() {
		double[] values = {1.0, 5.6, 3.5};
		Deviation s = new Deviation(values);
		System.out.printf("Standard Deviation: %.4f\n", s.standardDeviation());
		
		Integer[] ints = {5, 5, 3};
		Deviation std = new Deviation(ints);
		System.out.printf("Standard Deviation: %.4f\n", std.standardDeviation());
	}
	
	public static void two() {
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
		
		System.out.printf("Area of shape: %.4f", s.area());
	}
	
	public static double getDouble(Scanner s, String message) {
		System.out.print(message + " ");
		double d = s.nextDouble();
		return d;
	}

}