package ch02.ex02_01;

import java.util.LinkedList;

public class CountLongerWords {

  private static int targetLength = 8;
  private static int threadNum = 10;

  private volatile long counterForParallelThread = 0;
  private volatile int workingThreads = 0;

  /**
   * Count longer words
   * @param words This function counts longer words from this list
   * @return count
   */
  public static long countLongerWordsSequential(LinkedList<String> words) {
    long count = 0;
    for (String w : words) {
      if (w.length() > targetLength) {
        count++;
      }
    }
    return count;
  }

  /**
   * Count longer words using parallel stream
   * @param words This function counts longer words from this list
   * @return count
   */
  public static long countLongerWordsParallelStream(LinkedList<String> words) {
    long count = words.parallelStream().filter(w -> w.length() > targetLength).count();
    return count;
  }

  /**
   * Count longer words using parallel threads
   * In this function, multiple threads works on separated segment of provided list
   * @param words This function counts longer words grom this list
   * @return count
   */
  public long countLongerWordsParallelThread(LinkedList<String> words) {
    counterForParallelThread = 0;
    if (words.size() < threadNum) {
      ++workingThreads;
      Thread thread = new Thread(countLongerWordsParallelThreadSegment(words, 0, words.size() - 1));
      thread.start();
    } else {
      Thread[] threads = new Thread[threadNum];
      for (int i = 0; i < threadNum - 1; i++) {
        ++workingThreads;
        threads[i] = new Thread(countLongerWordsParallelThreadSegment(words, i * words.size() / threadNum, (i + 1) * words.size() / threadNum - 1));
        threads[i].start();
      }
      ++workingThreads;
      threads[threadNum - 1] = new Thread(countLongerWordsParallelThreadSegment(words, (threadNum - 1) * words.size() / threadNum, words.size() - 1));
      threads[threadNum - 1].start();
    }
    synchronized (this) {
      while (workingThreads != 0) {
        try {
          wait();
        } catch (InterruptedException e) {
        }
      }
    }
    return counterForParallelThread;
  }

  public Runnable countLongerWordsParallelThreadSegment(LinkedList<String> words, int start, int end) {
    Runnable runnable = () -> {
      for (int i = start; i <= end; i++) {
        if (words.get(i).length() > targetLength) {
          synchronized (this) {
            ++counterForParallelThread;
          }
        }
      }
      --workingThreads;
      synchronized (this) {
        notifyAll();
      }
    };
    return runnable;
  }

  public static void main(String[] args) {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }

    long start = 0;
    long end = 0;

    start = System.currentTimeMillis();
    System.out.println("Sequential version result: " + CountLongerWords.countLongerWordsSequential(words));
    end = System.currentTimeMillis();
    System.out.println("Sequential version time: " + (end - start) + "msec");

    System.out.println("");

    start = System.currentTimeMillis();
    System.out.println("ParallelStream version result: " + CountLongerWords.countLongerWordsParallelStream(words));
    end = System.currentTimeMillis();
    System.out.println("ParallelStream version time: " + (end - start) + "msec");

    System.out.println("");

    CountLongerWords ex02_01 = new CountLongerWords();
    start = System.currentTimeMillis();
    System.out.println("ParallelThread version result: " + ex02_01.countLongerWordsParallelThread(words));
    end = System.currentTimeMillis();
    System.out.println("ParallelThread version time: " + (end - start) + "msec");
  }

}
