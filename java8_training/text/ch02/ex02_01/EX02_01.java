package ch02.ex02_01;

import java.util.LinkedList;

public class EX02_01 {

  private long counterForParallelThread = 0;

  public static long countLongerWordsSequential(LinkedList<String> words) {
    long count = 0;
    for (String w: words) {
      if (w.length() > 8) {
        count++;
      }
    }
    return count;
  }

  public static long countLongerWordsParallelStream(LinkedList<String> words) {
    long count = words.parallelStream().filter(w -> w.length() > 8).count();
    return count;
  }

  public static long countLongerWordsParallelThread(LinkedList<String> words) {
    Thread[] threads = new Thread[10];
    
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
