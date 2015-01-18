package ch06.ex06_09;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void test() {
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

}
