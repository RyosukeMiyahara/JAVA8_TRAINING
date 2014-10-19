package ch01.ex01_08;

import java.util.ArrayList;
import java.util.List;

public class CaptureValueInExtendedFor {

  public static void main(String[] args) {
    // --- Provided code start ---
    String[] names = { "Peter", "Paul", "Mary" };
    List<Runnable> runners = new ArrayList<>();
    for (String name : names)
      runners.add(() -> System.out.println(name));
    // --- Provided code end ---

    for (Runnable runner : runners) {
      Thread thread = new Thread(runner);
      thread.start();
    }

    /*
    System.out.println("--- Traditional for loop ---");
    // --- Modified provided code start ---
    List<Runnable> runners2 = new ArrayList<>();
    for (int i = 0; i < names.length; i++)
      runners2.add(() -> System.out.println(names[i])); // Compile Error
    // --- Provided code end ---

    for (Runnable runner : runners) {
      Thread thread = new Thread(runner);
      thread.start();
    }
    */
  }

}
