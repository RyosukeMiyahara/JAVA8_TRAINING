package ch01.ex01_11;

public interface J {
  // public abstract void f();
/*
  default public void f() {
    System.out.println("Implemented in J as default");
  }
*/

  static public void f() {
    System.out.println("Implemented in J as static");
  }
}
