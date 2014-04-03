package ops.exprs;

import java.util.Scanner;

public class OpsAndExpressions {

	public static void main(String[] args) {
		quadratics();
	}
	
	public static void angles() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("angle: ");
		double a = input.nextFloat();
		
		input.close();
		
		double radians = Math.toRadians(a);
		double s = Math.sin(radians);
		double c = Math.cos(radians);
		double t = Math.tan(radians);
		
		System.out.printf("Sine:    %.4f\n", s);
		System.out.printf("Cosine:  %.4f\n", c);
		System.out.printf("Tangent: %.4f\n", t);
	}
	
	public static void quadratics(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("a: ");
		int a = input.nextInt();
		
		System.out.print("b: ");
		int b = input.nextInt();
		
		System.out.print("c: ");
		int c = input.nextInt();
		
		input.close();
		
		double partialResult = ((b*b) - (4.0*a*c));
		
		if (partialResult < 0) {  
			System.out.println("No real roots.");
			return;
		}
		
		double root1 = (b*-1 + Math.sqrt(partialResult))/(2*a);
		
		if (partialResult == 0) {
			System.out.printf("One root: %.4f\n", root1);
			return;
		}
		
		double root2 = (b*-1 - Math.sqrt(partialResult))/(2*a);
		
		System.out.printf("Root 1: %.4f\n", root1);
		System.out.printf("Root 2: %.4f\n", root2);
	}
	
	public static void circleInSquare(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Radius: ");
		double r = input.nextFloat();
		
		input.close();
		
		double width = r*2;
		System.out.printf("Smallest Square Width: %.4f\n", width);
	}
	
	public static void cicles(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Radius: ");
		double r = input.nextFloat();
		
		input.close();
		
		double pi = Math.PI;
		
		double perimeter = r*2*pi;
		System.out.printf("Perimeter: %.4f\n", perimeter);
		
		double area = r*r*pi;
		System.out.printf("Area: %.4f\n", area);
		
		double surface = 4*r*r*pi;
		System.out.printf("Surface: %.4f\n", surface);
		
		double volume = (4/3)*Math.pow(r, 3)*pi;
		System.out.printf("Volume: %.4f\n", volume);
	}
	
	public static void floatMaths(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("First input: ");
		double a = input.nextFloat();
		
		System.out.print("Second input: ");
		double b = input.nextFloat();
		
		input.close();
		
		double sum = a + b;
		double difference = a - b;
		double product = a * b;
		double quotient = a / b;
		
		System.out.printf("Sum: %.4f\n", sum);
		System.out.printf("Difference: %.4f\n", difference);
		System.out.printf("Product: %.4f\n", product);
		System.out.printf("Quotient: %.4f\n", quotient);
	}
	
	
	// moonmoon
	public static void basicMaths() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("First input: ");
		int a = input.nextInt();
		
		System.out.print("Second input: ");
		int b = input.nextInt();
		
		input.close();
		
		int sum = a + b;
		System.out.println("Sum: " + sum);
		
		int difference = a - b;
		System.out.println("Difference: " + difference);

		int product = a * b;
		System.out.println("Product: " + product);
		
		int quotient = a / b;
		int modulus = a % b;
		System.out.println("Division: " + quotient + " remainder " + modulus);
	}
	
}
