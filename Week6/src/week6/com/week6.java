package week6.com;

import java.util.ArrayList;
import java.util.Scanner;

public class week6 {

	public static void main(String[] args) {
		
	}
	
	public static void three() {
		Double[] values = {1.0, 5.6, 3.5};
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

class Employee {
	
	public String id;
	public String first_name;
	public String surname;
	public String job_title;
	
	Employee(String id,
			 String first_name,
			 String surname,
			 String job_title) {
		this.id = id;
		this.first_name = first_name;
		this.surname = surname;
		this.job_title = job_title;
	}
	
}

class Roster {
	ArrayList<Employee> employees;
	
	Roster(ArrayList<Employee> e) {
		employees = e;
	}
	
	public String getName(String id) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.id.equals(id)) {
				return employee.first_name + " " + employee.surname;
			}
		}
		
		return "not found";
	}
	
	public String getJobTitle(String id) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.id.equals(id)) {
				return employee.job_title;
			}
		}
		
		return "not found";
	}
	
	public String getID(String surname) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.surname.equals(surname)) {
				return employee.id;
			}
		}
		
		return "not found";
	}
	
	public void setJobTitle(String id, String jobTitle) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.id.equals(id)) {
				employee.job_title = jobTitle;
			}
		}
	}
}

class Deviation {
	
	Double[] numbers;
	
	Deviation(Integer[] v) {
		numbers = new Double[v.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (double) v[i];
		}
	}
	
	Deviation(Double[] v) {
		numbers = v;
	}
	
	public double mean() {
		double total = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		
		double mean = total / (double) numbers.length;
		
		return mean;
	}
	
	public double standardDeviation() {
		double mean = this.mean();
		
		// double[] deviations = new double[numbers.length];
		
		double deviation;
		double total = 0;
		for (int i = 0; i < numbers.length; i++) {
			deviation = numbers[i] - mean;
			deviation = Math.pow(deviation, 2);
			total += deviation;
		}
		
		double variance = total / numbers.length;
		
		variance = Math.sqrt(variance);
		
		return variance;
	}
	
}

class Shape {
	
	public double area() {
		return 0.0;
	}
	
}

class Circle extends Shape {
	
	double radius;
	
	Circle(Scanner s) {
		radius = week6.getDouble(s, "Enter a radius: ");
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

class Triangle extends Shape {
	
	double width;
	double height;
	
	Triangle(Scanner s) {
		width  = week6.getDouble(s, "Enter a width: ");
		height = week6.getDouble(s, "Enter a height: ");
	}
	
	Triangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height * 0.5;
	}
	
}

class Rectangle extends Shape {
	
	double width;
	double height;
	
	Rectangle(Scanner s) {
		width  = week6.getDouble(s, "Enter a width: ");
		height = week6.getDouble(s, "Enter a height: ");
	}
	
	Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double area() {
		return width * height;
	}
	
}

class Square extends Shape {
	
	double width;
	
	Square(Scanner s) {
		width = week6.getDouble(s, "Enter a width: ");
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

class Sphere {
	
	double radius;
	
	Sphere(double r) {
		radius = r;
	}
	
	public double surfaceArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
	
	public double volume() {
		return (4 * Math.PI * Math.pow(radius, 3)) / 3;
	}
}