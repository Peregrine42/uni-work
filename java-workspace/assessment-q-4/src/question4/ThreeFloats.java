package question4;

import java.util.Scanner;

public class ThreeFloats {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String floats_as_string = "";
		while (floats_as_string.length() < 1) {
			System.out.println("Please enter three numbers seperated by spaces:");
			floats_as_string = input.nextLine();
		}
		input.close();
		
		String[] strings = floats_as_string.split(" +");
		
		System.out.println("You input:");
		
		float total = 0;
		for (String string : strings) {
			System.out.println(string);
			float number = Float.parseFloat(string);
			total += number;
		}
		
		float average = total/strings.length;
		System.out.printf("Average: %.4f\n", average);
	}
	
}