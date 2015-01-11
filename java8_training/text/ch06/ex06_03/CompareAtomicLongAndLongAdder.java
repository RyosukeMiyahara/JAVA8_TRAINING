package ch06.ex06_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class CompareAtomicLongAndLongAdder {
  AtomicLong atomicLong = new AtomicLong();
  LongAdder longAdder = new LongAdder();

  public static final int THREAD_NUM = 1000;
  public static final int COUNT_TIMES = 100000;

  public static void main(String[] args) {
    ExecutorService pool = Executors.newCachedThreadPool();

    long start = 0;
    long end = 0;

    start = System.nanoTime();
    CompareAtomicLongAndLongAdder forAtomicLong = new CompareAtomicLongAndLongAdder();
    for (int i = 0; i < THREAD_NUM; i++)
       pool.submit(() -> {
             for (int j = 0;  j < COUNT_TIMES; j++) {
                forAtomicLong.atomicLong.incrementAndGet();
             }
          });
    pool.shutdown();
    try {
      pool.awaitTermination(10, TimeUnit.SECONDS);
    } catch (Exception e) {
      e.printStackTrace();
    }
    end = System.nanoTime();
    System.out.println("AtomicLong version time: " + (end - start) + "nsec");

    start = 0;
    end = 0;
    pool = Executors.newCachedThreadPool();

    start = System.nanoTime();
    CompareAtomicLongAndLongAdder forLongAdder = new CompareAtomicLongAndLongAdder();
    for (int i = 0; i < THREAD_NUM; i++)
       pool.submit(() -> {
             for (int j = 0;  j < COUNT_TIMES; j++) {
                forLongAdder.longAdder.increment();
             }
          });
    pool.shutdown();
    try {
      pool.awaitTermination(10, TimeUnit.SECONDS);
    } catch (Exception e) {
      e.printStackTrace();
    }
    end = System.nanoTime();
    System.out.println(" LongAdder version time: " + (end - start) + "nsec");
  }

}
