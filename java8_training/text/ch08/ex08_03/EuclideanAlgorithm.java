package ch08.ex08_03;

//数学的な（負ではない）余り、とは？？？

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

  public static int gcd_rem(int a, int b) {
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    if (b == 0) {
      return a;
    }
    return gcd_rem(b, rem(a, b));
  }

  public static int rem(int a, int b) {

    System.out.println("rem=" + ((a % b) + b) % b);
    return ((a % b) + b) % b;
    // return (a - (a/b)*b);
  }

  public static void main(String[] args) {
    System.out.println(gcd_percent(40, -50));
    System.out.println(gcd_floorMod(-50, -40));
    System.out.println(gcd_rem(40, -50));
  }

}
