package ch06.ex06_09;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {

  /**
   * Multiply provided any size matrixes
   *
   * @param matrix1 left matrix to be multipled
   * @param matrix2 right matrix to be multiplied
   * @Exception NullPointerException, IllegalArgumentException
   */
  public static double[][] multiply(double matrix1[][], double matrix2[][])
  {
    Objects.requireNonNull(matrix1, "matrix1 must not be null");
    Objects.requireNonNull(matrix2, "matrix2 must not be null");

    if (matrix1[0].length != matrix2.length) {
      throw new IllegalArgumentException("The number of matrix1 row needs to equal to the number of matrix2 column");
    }

    double[][] result = new double[matrix1.length][matrix2[0].length];
    for (int i = 0; i < matrix1.length; i++) {
      for (int j = 0; j < matrix2[0].length; j++) {
        result[i][j] = 0;
        for (int k = 0; k < matrix2.length; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {
    double[][][] matrixes = new double[10][][];
    Arrays.parallelSetAll(matrixes, i -> {
      double[][] matrix = {{1, 1}, {1, 0}};
      return matrix;
    });
    Arrays.parallelPrefix(matrixes, (first, second) -> {
      double[][] result = Matrix.multiply(first, second);
      return result;
    });
    for(int i = 0; i < matrixes.length; i++) {
      System.out.println(matrixes[i][0][0]);
    }
  }
}
