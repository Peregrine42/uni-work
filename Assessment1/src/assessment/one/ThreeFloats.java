package assessment.one;

public class ThreeFloats {

	public static void main(String[] args) {
		String input = "3.0   1     25";
		String[] inputs = input.split(" +");
		float total = 0;
		for (int i = 0; i < inputs.length; i++) {
			float f = Float.parseFloat(inputs[i]);
			total += f;
		}
		
		float average = total / inputs.length;
		System.out.printf("Inputs\n%.4f", average);
	}
	
}
