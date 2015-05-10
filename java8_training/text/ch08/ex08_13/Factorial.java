package ch08.ex08_13;

public class Factorial {

  @TestCase(params=4, expected=24)
  @TestCase(params=0, expected=1)
  @TestCase(params=4, expected=2) // NG case
  public static long factorial(int n) {
    long result = 1;
    for (int i = n; i > 0; i--) {
      result = result * i;
    }
    return result;
  }
}
