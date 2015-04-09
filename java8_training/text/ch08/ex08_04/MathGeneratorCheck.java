package ch08.ex08_04;


public class MathGeneratorCheck {

  private static long m = 25214903917L;
  private static long a = 11L;
  private static long N = (long)Math.pow(2, 48);
  private static long v = 246154705703781L;

  public static long next(long s) {
    return s * m + a % N;
  }

  public static long prev(long s) {
    return (s-a) * v % N;
  }

  // nextDoubleを376050回呼び出した後に0を得ます。??

}
