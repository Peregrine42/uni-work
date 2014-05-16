package assessment.q19.test;

import assessment.q19.Matrix;

import org.junit.Test;
import org.junit.Assert;

public class MatrixTest {
	
	@Test
	public void sizeTwoMatrixTest() {
		int[][] a = { { 42, 43 },
				      { 44, 45 } };
		
		int[][] b = { { 46, 47 },
			          { 48, 49 } };
		
		int[][] expected = { { 3996, 4081 },
		                     { 4184, 4273 } };
		
		Assert.assertArrayEquals(expected, Matrix.dotProduct(a, b));
	}
	
	@Test
	public void sizeThreeMatrixTest() {
		int[][] a = { { 1, 2, 3 },
				      { 4, 5, 6 },
		              { 7, 8, 9 } };
		
		int[][] b = { { 9, 8, 7 },
			          { 6, 5, 4 },
	                  { 3, 2, 1 } };
		
		int[][] expected = { { 30,  24,  18 },
		                     { 84,  69,  54 },
                             { 138, 114, 90 } };
		
		Assert.assertArrayEquals(expected, Matrix.dotProduct(a, b));
	}
	
	@Test
	public void sizeFourMatrixTest() {
		int[][] a = { { 1,  2,  3,  6  },
				      { 4,  5,  6,  15 },
		              { 7,  8,  9,  24 },
		              { 10, 11, 12, 33 } };
		
		int[][] b = { { 9,  8,  7,  6  },
			          { 6,  5,  4,  15 },
	                  { 3,  2,  1,  24 },
	                  { 10, 11, 12, 33 } };
		
		int[][] expected = { { 90,  90,  90,  306  },
		                     { 234, 234, 234, 738  },
                             { 378, 378, 378, 1170 },
                             { 522, 522, 522, 1602 } };
		
		Assert.assertArrayEquals(expected, Matrix.dotProduct(a, b));
	}
	
	@Test
	public void convertIntMatrixToDoubleTest() {
		int[][] a = { { 42, 43 },
				      { 44, 45 } };
		
		double[][] expected = { { 42.0, 43.0 },
		                        { 44.0, 45.0 } };
		
		Assert.assertArrayEquals(expected, Matrix.convertIntArrayToDoubleArray(a));
	}
	
	@Test
	public void convertDoubleMatrixToIntTest() {
		double[][] a = { { 42.0, 43.0 },
				         { 44.0, 45.0 } };
		
		int[][] expected = { { 42, 43 },
		                     { 44, 45 } };
		
		Assert.assertArrayEquals(expected, Matrix.convertDoubleArrayToIntArray(a));
	}
}