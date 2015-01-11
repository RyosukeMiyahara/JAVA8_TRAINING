package ch06.ex06_01;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

public class MaxLengthManager {
  public AtomicReference<Integer> maxLength = new AtomicReference<Integer>();

  public static void main(String[] args) {
    MaxLengthManager maxLengthManager = new MaxLengthManager();
    maxLengthManager.maxLength.set(0);

    String contents = null;
    try {
      contents = new String(Files.readAllBytes(Paths.get("text/ch06/ex06_01/alice.txt")), StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.err.println("Read text file failed...");
      e.printStackTrace();
    }
    String[] words = contents.split("[\\P{L}]+");

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < words.length / 3; i++) {
        maxLengthManager.maxLength.accumulateAndGet(words[i].length(), Math::max);
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = words.length / 3; i < (words.length / 3) * 2; i++) {
        maxLengthManager.maxLength.accumulateAndGet(words[i].length(), Math::max);
      }
    });

    Thread thread3 = new Thread(() -> {
      for (int i = (words.length / 3) * 2; i < words.length; i++) {
        maxLengthManager.maxLength.accumulateAndGet(words[i].length(), Math::max);
      }
    });

    thread1.start();
    thread2.start();
    thread3.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (Exception e) {
      System.err.println("join failed");
      e.printStackTrace();
    }

    System.out.println("Result: " + maxLengthManager.maxLength.get());
  }

}
