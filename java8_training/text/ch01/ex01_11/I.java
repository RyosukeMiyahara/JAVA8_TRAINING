package ch01.ex01_11;

public interface I {
   // public abstract void f();
/*
  default public void f() {
    System.out.println("Implemented in I as default");
  }
*/

  static public void f() {
    System.out.println("Implemented in I as static");
  }

}
