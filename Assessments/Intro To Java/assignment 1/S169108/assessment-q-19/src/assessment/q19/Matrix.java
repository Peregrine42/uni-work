package assessment.q19;

public class Matrix {
	
	public static double[][] dotProduct(double[][] a, double[][] b) {
		double[][] result = new double[a.length][a.length];
		
		for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a.length; x++) {
                for (int i = 0; i < a.length; i++) {
                	result[y][x] += a[y][i] * b[i][x];
                }
            }
        }
        return result;
	}
	
	public static int[][] dotProduct(int[][] a, int[][] b) {
		double[][] x = convertIntArrayToDoubleArray(a);
		double[][] y = convertIntArrayToDoubleArray(b);
		
		double[][] result = dotProduct(x, y);
		
		return convertDoubleArrayToIntArray(result);
	}
	
	public static double[][] convertIntArrayToDoubleArray(int[][] a) {
		double[][] result = new double[a.length][a.length];
		
		for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a.length; x++) {
                result[y][x] = (double) a[y][x];
            }
        }
		
		return result;
	}
	
	public static int[][] convertDoubleArrayToIntArray(double[][] a) {
		int[][] result = new int[a.length][a.length];
		
		for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a.length; x++) {
                result[y][x] = (int) a[y][x];
            }
        }
		
		return result;
	}
}