package w9.interfaces;

import java.util.Scanner;

class Square extends Shape {
	
	double width;
	
	Square(Scanner s) {
		width = Week9.getDouble(s, "Enter a width: ");
	}
	
	Square(double w) {
		width = w;
	}
	
	public double perimeter() {
		return 4 * width;
	}
	
	public double area() {
		return Math.pow(width, 2);
	}
	
}