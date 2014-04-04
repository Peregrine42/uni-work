package w9.interfaces;

import java.util.Scanner;

class Rectangle extends Shape {
	
	double width;
	double height;
	
	Rectangle(Scanner s) {
		width  = Week9.getDouble(s, "Enter a width: ");
		height = Week9.getDouble(s, "Enter a height: ");
	}
	
	Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height;
	}
	
	public double perimeter() {
		return (width * 2) + (height * 2);
	}
	
}