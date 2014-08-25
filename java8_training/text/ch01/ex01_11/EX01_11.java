package ch01.ex01_11;

public class EX01_11 implements I, J{

  // @Override
  public void f() {
    System.out.println("Implemented in EX01_11.");
  }



  public static void main(String[] args) {
    EX01_11 test = new EX01_11();
    test.f();
  }

}
