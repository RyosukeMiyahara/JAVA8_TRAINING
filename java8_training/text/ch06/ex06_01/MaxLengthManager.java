package ch06.ex06_01;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class MaxLengthManager {
  public AtomicReference<Integer> maxLength = new AtomicReference<Integer>();
  public static final int THREAD_NUM = 3;

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

    ExecutorService pool = Executors.newCachedThreadPool();
    for (int i = 0; i < THREAD_NUM; i++) {
      int offset = i;
      pool.submit(() -> {
        for (int j = words.length / THREAD_NUM * offset; j < words.length / THREAD_NUM * (offset + 1); j++) {
          maxLengthManager.maxLength.accumulateAndGet(words[j].length(), Math::max);
        }
      });
    }
   pool.shutdown();
   try {
     pool.awaitTermination(10, TimeUnit.SECONDS);
   } catch (Exception e) {
     e.printStackTrace();
   }

    System.out.println("Result: " + maxLengthManager.maxLength.get());
  }

}
