package week6.com;

public class Deviation {
	
	double[] numbers;
	
	public Deviation(Integer[] v) {
		numbers = new double[v.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (double) v[i];
		}
	}
	
	public Deviation(double[] v) {
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
		
		double variance = 0.0;
		if (total != 0.0) {
			variance = total / numbers.length;
		}
		
		variance = Math.sqrt(variance);
		
		return variance;
	}
	
}
