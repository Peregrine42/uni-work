package week4;

import java.util.ArrayList;

public class week4 {
	
	public static void main(String[] args) {
		one();
		int[][] m1 = { {2, 3, 4}, {1, 0, 1}, {4, 3, 2} };
		int[][] m2 = { {5, 3, 5}, {1, 0, 1}, {3, 2, 3} };
		
		int[][] mult = new int[m1.length][m1[0].length];
		
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				mult[i][j] = m1[i][j] * m2[i][j];
			}
		}
		
		for (int[] item : mult) {
			for (int i : item) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static void four() {
		int[][] matrix = { {1, 2, 3}, {4, 5, 6} };

		int[][] transpose = new int[matrix[0].length][matrix.length];
		
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				transpose[i][j] = matrix[j][i];
			}
		}
		
		for (int[] item : transpose) {
			for (int i : item) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static void three() {
		int length = 20;
		
		int[] fib = new int[length];
		fib[0] = 1;
		fib[1] = 1;
		
		for (int i = 2; i < length; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		for (int item : fib) {
			System.out.println(item);
		}
	}
	
	public static void two() {
		ArrayList<Integer> possibleValues = new ArrayList<Integer>();
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				possibleValues.add(i + j);
			}
		}
		
		System.out.println(possibleValues);
	}
	
	public static void one() {
		Integer[] numbers = { 17, 89, 27, 11, 91, 42, 73, 90, 5, 56 };
		
		int minimum = min(numbers);
		int maximum = max(numbers);
		System.out.println("Min: " + minimum);
		System.out.println("Max: " + maximum);
		
		int range = maximum - minimum;
		System.out.println("Range: " + range);
		
		double mean = mean(numbers);
		System.out.printf("Mean: %.4f\n", mean);
		
		double stdDev = standardDeviation(mean, numbers);
		System.out.printf("Standard Deviation: %.4f\n", stdDev);
	}
	
	public static int min(Integer[] numbers) {
		int min_value = numbers[0];
		
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < min_value) {
				min_value = numbers[i];
			}
		}
		
		return min_value;
	}
	
	public static int max(Integer[] numbers) {
		int max_value = numbers[0];
		
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max_value) {
				max_value = numbers[i];
			}
		}
		
		return max_value;
	}
	
	public static double mean(Integer[] numbers) {
		int total = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		
		double mean = total / (double) numbers.length;
		
		return mean;
	}
	
	public static double standardDeviation(double mean, Integer[] numbers) {
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
