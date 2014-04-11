package assessment.rsa;

public class Encrypter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getFoo() {
		return "foo";
	}
	
	int[] extEuc(int a, int b) {
		if (b == 0) {
			int[] result = { a, 1, 0 };
			return result;
		} else {
			int[] resultPrime = extEuc(b, a % b);
			
			int dPrime = resultPrime[0];
			int xPrime = resultPrime[1];
			int yPrime = resultPrime[2];
			int[] result = { dPrime, yPrime, (int) ((int) xPrime - (Math.floor(a/b)*yPrime)) };
			return result;
		}
	}
	
	int[] extEucIter(int a, int b) {
		int prevx = 1;
		int x = 0;
		
		int prevy = 0;
		int y = 1;
		
		while (b > 0) {
			double q = ((double) a) / ((double) b);
			int q_as_int = (int) q;
			
			int oldx = x;
			x = prevx - (q_as_int * x);
			prevx = oldx;
			
			int oldy = y;
			y = prevy - (q_as_int * y);
			prevy = oldy;
			
			b = a % b;
			a = b;
		}
		int[] result = { a, prevx, prevy };
		return result;
	}
	
	public int[] egcd(int a, int b) {
		if (a == 0) {
			int[] result = { b, 0, 1 };
			return result;
		} else {
			int[] result = egcd(b % a, a);
			int g = result[0];
			int y = result[1];
			int x = result[2];
			
			int[] answer = { g, x - (b/a)*y, y };
			return answer;
		}
	}
	
	public int[] ExtEuclid(int a, int b) {
		if (b == 0) {
			int[] result = { a, 1, 0 };
			return result;
		}
		
		int[] resultPrime = ExtEuclid(b, a % b);
		int d1 = resultPrime[0];
		int s1 = resultPrime[1];
		int t1 = resultPrime[2];
		
		int d = d1;
		int s = t1;
		int t = s1 - (a / b) * t1;
		int[] result = { d, s, t };
		return result;
	}
	
	public int getD(int e, int phi) {
		int[] result = ExtEuclid(e, phi);
		int r = result[0];
		int b = result[1];
		int a = result[2];
		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(r);
		
		if (b < 0) {
			int d = b + phi;
			return d;
		} else if (b >= phi) {
			int d = b % phi;
			return d;
		} else {
			int d = b;
			return d;
		}
	}
	
	public int getE() {
		return 65537;
	}
	
	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}