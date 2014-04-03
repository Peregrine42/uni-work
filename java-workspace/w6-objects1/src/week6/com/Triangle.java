package week6.com;

import java.util.Scanner;

class Triangle extends Shape {
	
	double width;
	double height;
	
	Triangle(Scanner s) {
		width  = Week6.getDouble(s, "Enter a width: ");
		height = Week6.getDouble(s, "Enter a height: ");
	}
	
	Triangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height * 0.5;
	}
	
}