package ch08.ex08_12;

public class Factorial {

  @TestCase(params=4, expected=4)
  @TestCase(params=0, expected=1)
  public static long factorial(int n) {
    long result = 1;
    for (int i = n; i > 0; i--) {
      result = result * n;
    }
    return result;
  }
}
