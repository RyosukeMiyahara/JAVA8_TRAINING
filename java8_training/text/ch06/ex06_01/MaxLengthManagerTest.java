package ch06.ex06_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxLengthManagerTest {

  @Test
  public void test() {
    MaxLengthManager maxLengthManager = new MaxLengthManager();
    maxLengthManager.maxLength.set(0);

    String words[] = {
        "panda",         // 5
        "giant-panda",   // 11
        "lesser-panda",  // 12
        "normal-panda",  // 12
        "super-panda",   // 11
        "miracle-panda", // 13
        "pandas",        // 6
        "no-panda",      // 8
        "other-panda",   // 11
    };

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

    assertEquals(13, (int)maxLengthManager.maxLength.get());
  }

}
