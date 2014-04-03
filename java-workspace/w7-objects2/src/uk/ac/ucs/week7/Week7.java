package uk.ac.ucs.week7;
import week6.com.Deviation;

public class Week7 {

	public static void main(String[] args) {
		four(args);
	}
	
	public static double[] convertToDoubles(String[] args) {
		double[] double_args = new double[args.length];
		for (int i = 0; i < args.length; i++) {
			double_args[i] = Double.parseDouble(args[i]);
		}
		
		return double_args;
	}
	
	public static void four(String[] args) {
		double[] doubles = convertToDoubles(args);
		System.out.printf("%.4f", new Deviation(doubles).standardDeviation());
	}
	
	public static void three() {
		String s = "e28 8pb";
		System.out.println(PostCodeValidator.valid(s));
	}
	
	public static void two() {
		Circle c = new Circle(new Point(0,0), 4);
		Point p = new Point(3, 4);
		String s = "is not";
		if (c.contains(p)) {
			s = "is";
		}
		System.out.print(p + " " + s + " in the circle:");
	}
	
	public static void one() {
		Rectangle r = new Rectangle(new Point(0,2), 
					                new Point(2,2),
					                new Point(0,0),
					                new Point(2,0));

		System.out.printf("%.4f units\n", r.perimeter());
		System.out.printf("%.4f units squared\n", r.area());
	}
}