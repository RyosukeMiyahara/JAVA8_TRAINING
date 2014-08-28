package ch02.ex02_03;

import java.util.LinkedList;

public class EX02_03 {

  private static final int targetLength = 8;

  public static long countLongerWordsStream(LinkedList<String> words) {
    long count = words.stream().filter(w -> w.length() > targetLength).count();
    return count;
  }

  public static long countLongerWordsParallelStream(LinkedList<String> words) {
    long count = words.parallelStream().filter(w -> w.length() > targetLength).count();
    return count;
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

    start = System.nanoTime();
    System.out.println("        Stream version result: " + EX02_03.countLongerWordsStream(words));
    end = System.nanoTime();
    System.out.println("        Stream version time: " + (end - start) + "nsec");

    System.out.println("");

    start = System.nanoTime();
    System.out.println("ParallelStream version result: " + EX02_03.countLongerWordsParallelStream(words));
    end = System.nanoTime();
    System.out.println("ParallelStream version time: " + (end - start) + "nsec");

  }

}
