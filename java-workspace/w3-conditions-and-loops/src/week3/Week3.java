package week3;

import java.util.Scanner;

public class Week3 {
	
	public static void main(String[] args) {
		three();
	}
	
	public static void six() {
		for (int i = 1; i <= 12; i++) {
			for (int j = 0; j <= 12; j++) {
				System.out.print(i*j + "\t");
			}
			System.out.println();
		}
	}
	
	public static void five() {
		Scanner input = new Scanner(System.in);
		
		double input_value = 0;
		double result;
		while (input_value <= 0) {
			input_value = getDouble(input, "Enter a number greater than 0: ");
		}
		for (int i = 0; i < 21; i++) {
			 result = Math.pow(input_value, i);
			 System.out.printf("%.4f to the power of %d is %.4f\n", input_value, i, result);
		}
	}
	
	public static void four() {
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		int input_value = 0;
		while (sum < 1024) {
			input_value = getInt(input, "Enter a number (enter -1 to stop): ");
			if (input_value == -1) {
				break;
			}
			sum += input_value;
		}
		
		System.out.println("sum: " + sum);
	}
	
	public static void three() {
		Scanner input = new Scanner(System.in);
		
		int max_value = getInt(input, "Enter a first number: ");
		int min_value = max_value;
		int input_value = max_value;
		do {
			if (input_value > max_value) {
				max_value = input_value;
			}
			if (input_value < min_value) {
				min_value = input_value;
			}
			input_value = getInt(input, "Enter another number (enter -1 to stop): ");
		} while (input_value != -1);
		
		System.out.println("max value: " + max_value);
		System.out.println("min value: " + min_value);
	}
	
	public static int getInt(Scanner s, String message) {
		System.out.print(message + " ");
		int i = s.nextInt();
		return i;
	}
	
	public static double getDouble(Scanner s, String message) {
		System.out.print(message + " ");
		double i = s.nextDouble();
		return i;
	}
	
	public static void twoA() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("shape? ");
		String shape = input.next();
		if        (shape.equals("T")) {
			int b = getInt(input, "what is the breadth?");
			int h = getInt(input, "what is the height?");
			double area = b * h * 0.5;
			System.out.printf("area: %.4f", area);
		} else if (shape.equals("S")) {
			int w = getInt(input, "what is the width?");
			double area = w * w;
			System.out.printf("area: %.4f", area);
		} else if (shape.equals("R")) {
			int b = getInt(input, "what is the width?");
			int h = getInt(input, "what is the height?");
			double area = b * h;
			System.out.printf("area: %.4f", area);
		} else if (shape.equals("C")) {
			int r = getInt(input, "what is the radius?");
			double area = r * r * Math.PI;
			System.out.printf("area: %.4f", area);
		} else {
			System.out.println("invalid shape");
		}
	}
	
	public static void twoB() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("shape? ");
		String shape = input.next();
		switch (shape) {
			case "T": {
				int b = getInt(input, "what is the breadth?");
				int h = getInt(input, "what is the height?");
				double area = b * h * 0.5;
				System.out.printf("area: %.4f", area);
				break;
			}
			case "S": {
				int w = getInt(input, "what is the width?");
				double area = w * w;
				System.out.printf("area: %.4f", area);
				break;
			}
			case "R": {
				int b = getInt(input, "what is the width?");
				int h = getInt(input, "what is the height?");
				double area = b * h;
				System.out.printf("area: %.4f", area);
				break;
			}
			case "C": {
				int r = getInt(input, "what is the radius?");
				double area = r * r * Math.PI;
				System.out.printf("area: %.4f", area);
				break;
			}
			default: {
				System.out.println("invalid shape");
				break;
			}
		}
	}
	
	public static void one() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("first value? ");
		int a = s.nextInt();
		System.out.print("second value? ");
		int b = s.nextInt();
		
		s.close();
		
		String result;
		if (a < b) {
			result = a + ", " + b;
		} else if (a > b) {
			result = b + ", " + a;
		} else {
			result = "a and b are the same";
		}
		
		System.out.println(result);
	}
}
