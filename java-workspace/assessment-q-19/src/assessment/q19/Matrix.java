package assessment.q19;

public class Matrix {

	public static int[][] dotProduct(int[][] a, int [][] b) {
		// assumes input of two square matrices 
		// of identical size
		
		int[][] result = new int[a.length][a.length];
		
		for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a.length; x++) {
                for (int i = 0; i < a.length; i++) {
                	result[y][x] += a[y][i] * b[i][x];
                }
                
            }
        }
        
        return result;
	}
}
