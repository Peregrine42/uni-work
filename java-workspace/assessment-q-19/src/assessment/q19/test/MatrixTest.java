package assessment.q19.test;

import assessment.q19.Matrix;

import org.junit.Test;
import org.junit.Assert;

public class MatrixTest {
	
	@Test
	public void convertIntMatrixToDoubleTest() {
		int[][] a = { { 42, 43 },
				      { 44, 45 } };
		
		double[][] expected = { { 42.0, 43.0 },
		                        { 44.0, 45.0 } };
		
		Assert.assertArrayEquals(expected, Matrix.convertIntArrayToDoubleArray(a));
	}
	
	@Test
	public void sizeTwoMatrixTest() {
		int[][] a = { { 42, 43 },
				      { 44, 45 } };
		
		int[][] b = { { 46, 47 },
			          { 48, 49 } };
		
		double[][] expected = { { 3996.0, 4081.0 },
		                        { 4184.0, 4273.0 } };
		
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
		
		double[][] expected = { { 30.0,  24.0,  18.0 },
		                        { 84.0,  69.0,  54.0 },
                                { 138.0, 114.0, 90.0 } };
		
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
		
		double[][] expected = { { 90.0,  90.0,  90.0,  306.0  },
		                        { 234.0, 234.0, 234.0, 738.0  },
                                { 378.0, 378.0, 378.0, 1170.0 },
                                { 522.0, 522.0, 522.0, 1602.0 } };
		
		Assert.assertArrayEquals(expected, Matrix.dotProduct(a, b));
	}
}