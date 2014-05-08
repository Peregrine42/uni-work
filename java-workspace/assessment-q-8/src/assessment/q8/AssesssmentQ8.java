package assessment.q8;

public class AssesssmentQ8 {
	
	public static void main(String[] args) {
	}
	
	public static void forLoopVersion() {
		int total = 0;
		
		for (int i = 0; i <= 10; i++) {
			total += i;
		}
		
		System.out.println(total);
	}
	
	public static void whileLoopVersion() {
		int counter = 1;
		int total = 0;
		
		while (counter <= 10) {
			total += counter;
			counter += 1;
		}
		
		System.out.println(total);
	}
	
	public static void doWhileLoopVersion() {
		int counter = 0;
		int total = 0;
		
		do {
			total += counter;
			counter += 1;
		} while (counter <= 0);
		
		System.out.println(total);
	}
}
