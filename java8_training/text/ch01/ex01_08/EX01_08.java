package ch01.ex01_08;

import java.util.ArrayList;
import java.util.List;

public class EX01_08 {

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
  }

}
