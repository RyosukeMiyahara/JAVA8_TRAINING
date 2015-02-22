package ch06.ex06_09;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void multiplyTest() {
    double[][] matrix1 = {
        {2.0, -1.0},
        {-3.0, 4.0}
    };
    double[][] matrix2 = {
        {1},
        {2},
    };
    double[][] expected = {
        {0},
        {5.0}
    };
    assertArrayEquals(expected, Matrix.multiply(matrix1, matrix2));
  }

  @Test
  public void fibonacchiTest() {
    double[][][] matrixes = new double[10][][];
    Arrays.parallelSetAll(matrixes, i -> {
      double[][] matrix = {{1, 1}, {1, 0}};
      return matrix;
    });
    Arrays.parallelPrefix(matrixes, (first, second) -> {
      double[][] result = Matrix.multiply(first, second);
      return result;
    });
    double[] expected = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
    for (int i = 0; i < matrixes.length; i++) {
      assertEquals(expected[i], matrixes[i][0][0], 0.001);
    }
  }
}
