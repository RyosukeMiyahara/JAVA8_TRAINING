package ch08.ex08_03;

public class EuclideanAlgorithm {

  public static int gcd_percent(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd_percent(b, a % b);
  }

  public static int gcd_floorMod(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd_floorMod(b, Math.floorMod(a, b));
  }
  public static void main(String[] args) {
    System.out.println(gcd_percent(40, -50));
    System.out.println(gcd_floorMod(-50, -40));
  }

}
