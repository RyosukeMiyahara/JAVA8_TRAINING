package ch02.ex02_01;

import java.util.LinkedList;

public class EX02_01 {

  private static int targetLength = 8;
  private static int threadNum = 10;

  private volatile long counterForParallelThread = 0;
  private volatile int workingThreads = 0;

  public static long countLongerWordsSequential(LinkedList<String> words) {
    long count = 0;
    for (String w: words) {
      if (w.length() > targetLength) {
        count++;
      }
    }
    return count;
  }

  public static long countLongerWordsParallelStream(LinkedList<String> words) {
    long count = words.parallelStream().filter(w -> w.length() > targetLength).count();
    return count;
  }

  public long countLongerWordsParallelThread(LinkedList<String> words) {
    counterForParallelThread = 0;
    if (words.size() < threadNum) {
      ++workingThreads;
      Thread thread = new Thread(countLongerWordsParallelThreadSegment(words, 0, words.size() - 1));
      thread.start();
    } else {
      Thread[] threads = new Thread[threadNum];
      for (int i = 0; i < threadNum; i++) {
        threads[i] = new Thread(countLongerWordsParallelThreadSegment(words, i * words.size()/threadNum, (i + 1) * words.size() / threadNum));
      }
    }
    while(workingThreads != 0) {
      try {
        wait();
      } catch(InterruptedException e) {
      }
    }
    return counterForParallelThread;
  }

  public Runnable countLongerWordsParallelThreadSegment(LinkedList<String> words, int start, int end) {
    Runnable runnable = () -> {
      for (int i = start; i <= end; i++) {
        if (words.get(i).length() > targetLength) {
          ++counterForParallelThread;
        }
      }
      --workingThreads;
      notifyAll();
    };
    return runnable;
  }

  public static void main(String[] args) {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 1000000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }

    long start = 0;
    long end = 0;

    start = System.currentTimeMillis();
    System.out.println("Sequential version result: " + EX02_01.countLongerWordsSequential(words));
    end = System.currentTimeMillis();
    System.out.println("Sequential version time: " + (end - start) + "msec");

    System.out.println("");

    start = System.currentTimeMillis();
    System.out.println("ParallelStream version result: " + EX02_01.countLongerWordsParallelStream(words));
    end = System.currentTimeMillis();
    System.out.println("ParallelStream version time: " + (end - start) + "msec");
  }

}
