package w9.interfaces;

import java.util.Scanner;

class Triangle extends Shape {
	
	double width;
	double height;
	
	Triangle(Scanner s) {
		width  = Week9.getDouble(s, "Enter a width: ");
		height = Week9.getDouble(s, "Enter a height: ");
	}
	
	Triangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height * 0.5;
	}
	
	
	public double hypotemuse() {
		double total = Math.pow(width, 2) + Math.pow(height, 2);
		return Math.sqrt(total);
	}
	
	public double perimeter() {
		return width + height + hypotemuse();
	}
	
}