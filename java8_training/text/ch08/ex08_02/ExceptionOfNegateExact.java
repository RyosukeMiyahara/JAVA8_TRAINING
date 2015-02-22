package ch08.ex08_02;

public class ExceptionOfNegateExact {

  public static void main(String[] args) {
    for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
      try {
        Math.negateExact(i);
      } catch (Exception e) {
        System.out.println("negateExact() throws exception for " + i);
      }
    }
  }

}
