package ch06.ex06_04;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorUser {

  public static final int THREAD_NUM = 3;

  public static void main(String[] args) {
    String contents = null;
    try {
      contents = new String(Files.readAllBytes(Paths.get("text/ch06/ex06_01/alice.txt")), StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.err.println("Read text file failed...");
      e.printStackTrace();
    }
    String[] words = contents.split("[\\P{L}]+");

    LongAccumulator longAccumulatorMax = new LongAccumulator(Math::max, 0);

    ExecutorService pool = Executors.newCachedThreadPool();
    for (int i = 0; i < THREAD_NUM; i++) {
      int offset = i;
      pool.submit(() -> {
        for (int j = words.length / THREAD_NUM * offset; j < words.length / THREAD_NUM * (offset + 1); j++) {
          longAccumulatorMax.accumulate(words[j].length());
        }
      });
    }
   pool.shutdown();
   try {
     pool.awaitTermination(10, TimeUnit.SECONDS);
   } catch (Exception e) {
     e.printStackTrace();
   }

   System.out.println("Longest word length is: " + longAccumulatorMax.get());

   LongAccumulator longAccumulatorMin = new LongAccumulator((left, right) -> {
     if (left == 0 && right == 0) {
       return 0;
     }
     if (left == 0) {
       return right;
     }
     if (right == 0) {
       return left;
     }
     return (Math.min(left, right));
   }, Long.MAX_VALUE);

   pool = Executors.newCachedThreadPool();
   for (int i = 0; i < THREAD_NUM; i++) {
     int offset = i;
     pool.submit(() -> {
       for (int j = words.length / THREAD_NUM * offset; j < words.length / THREAD_NUM * (offset + 1); j++) {
         longAccumulatorMin.accumulate(words[j].length());
       }
     });
   }
  pool.shutdown();
  try {
    pool.awaitTermination(10, TimeUnit.SECONDS);
  } catch (Exception e) {
    e.printStackTrace();
  }

  System.out.println("Shortest word length is: " + longAccumulatorMin.get());
  }

}
