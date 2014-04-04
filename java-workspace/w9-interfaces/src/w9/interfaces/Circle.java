package w9.interfaces;

import java.util.Scanner;

class Circle extends Shape {
	
	double radius;
	
	Circle(Scanner s) {
		radius = Week9.getDouble(s, "Enter a radius: ");
	}
	
	Circle(double r) {
		radius = r;
	}
	
	public double perimeter() {
		return 2 * radius * Math.PI;
	}
	
	public double area() {
		return Math.pow(radius, 2) * Math.PI;
	}
	
}