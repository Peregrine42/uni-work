package week.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class week5 {

	public static void main(String[] args) {
		three();
	}
	
	public static void three() {
		String input = "NNdgsdfgsdfgsdsssfgNNN";
		System.out.println(encode(input, 13, 5, "X"));
	}
	
	public static String encode(String input, int rotAmount, int chopAmount, String fillChar) {
		String encoded = "";
		String buffer = "";
		
		// step through input
		for (int i = 0; i < input.length(); i++) {
			
			// if our buffer has reached the chop amount, 
			// add it to the result string and reset
			if (buffer.length() >= chopAmount) {
				encoded = encoded + buffer + " ";
				buffer = "";
			}
			
			// do rotation
			char c = input.charAt(i);
			c = rotate(c, rotAmount);
			
			buffer = buffer + c;
		}
		
		// deal with trailing buffer
		if (buffer.length() > 0) {
			encoded = encoded + fill(buffer, fillChar, chopAmount);
		}
		
		return encoded.toUpperCase();
	}
	
	public static String fill(String input, String c, int amount) {
		for (int i = input.length(); i < amount; i++) {
			input = input + c;
		}
		return input;
	}
	
	public static void one() {
		String s = "dfjh asd... klfbn,adas.asdasd";
		s = dePunctuate(s);
		System.out.println(s);
	}
	
	public static void two() {
		String input = "aello";
		System.out.println(rotate(input, 3));
	}
	
	public static String rotate(String input, int amount) {
		String encoded = "";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			c += amount;
			encoded = encoded + c;
		}
		return encoded;
	}
	
	public static char rotate(char c, int rotAmount) {
		String s = String.valueOf(c);
		c = s.toLowerCase().charAt(0);
		int v = (int) c;
		v -= 97;
		v += rotAmount;
		v = v % 26;
		v += 97;
		c = (char) v;
		return c;
	}
	
	public static String dePunctuate(String s) {
		Pattern p = Pattern.compile("[^a-zA-Z]");
		Matcher m = p.matcher(s);
		s = m.replaceAll("");
		return s;
	}

}
