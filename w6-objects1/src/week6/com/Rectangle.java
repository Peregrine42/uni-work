package week6.com;

import java.util.Scanner;

class Rectangle extends Shape {
	
	double width;
	double height;
	
	Rectangle(Scanner s) {
		width  = Week6.getDouble(s, "Enter a width: ");
		height = Week6.getDouble(s, "Enter a height: ");
	}
	
	Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height;
	}
	
}