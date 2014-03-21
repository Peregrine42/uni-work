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
		System.out.print("Inputs: ");
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i] + " ");
		}
		System.out.printf("\nOutput: %.4f", average);
	}
	
}
