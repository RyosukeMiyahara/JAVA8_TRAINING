package ch02.ex02_13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX02_13 {
  public static long[] countShorterWords(int length, Stream<String> words) {
    long[] result = new long[length];
    Map<Object, Long> map = words.parallel().filter(s-> s.length() < length).parallel().collect(Collectors.groupingBy(s->s.length(), Collectors.counting()));
    for (int i = 0; i < length; i++) {
      if (map.containsKey(i)) {
        result[i] = map.get(i);
      } else {
        result[i] = 0;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }
    Stream<String> wordsStream = words.stream();

    System.out.println("intArray: ");
    long[] intArray = countShorterWords(8, wordsStream);
    System.out.println(Arrays.toString(intArray));
  }

}
