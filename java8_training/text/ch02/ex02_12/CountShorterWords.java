package ch02.ex02_12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CountShorterWords {

  /**
   * Count shorter words.
   * This is NG function because counter is not atomic
   * @param length Word shorter than this is counted
   * @param words Count shorter words from this stream
   * @return count
   */
  public static int[] countShorterWordsNG(int length, Stream<String> words) {
    int[] shortWords = new int [length];
    words.parallel().forEach(
        s->{ if (s.length() < length) shortWords[s.length()]++;});
    return shortWords;
  }

  /**
   * Count shorter words.
   * @param length Word shorter than this is counted
   * @param words Count shorter words from this stream
   * @return count
   */
  public static AtomicInteger[] countShorterWordsAtomic(int length, Stream<String> words) {
    AtomicInteger[] shortWords = new AtomicInteger[length];
    for(int i = 0; i < length; i++) {
      shortWords[i] = new AtomicInteger();
    }
    words.parallel().forEach(
        s->{ if (s.length() < length) shortWords[s.length()].getAndIncrement();});
    return shortWords;
  }

  public static void main(String[] args) {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }
    Stream<String> parallelWords1 = words.stream();
    Stream<String> parallelWords2 = words.stream();

    System.out.println("Normal array: ");
    int[] arrayNG = countShorterWordsNG(8, parallelWords1);
    System.out.println(Arrays.toString(arrayNG));

    System.out.println("AtomicInteger: ");
    AtomicInteger[] arrayAtomicInteger = countShorterWordsAtomic(8, parallelWords2);
    System.out.println(Arrays.toString(arrayAtomicInteger));
  }

}
