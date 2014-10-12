package ch02.ex02_11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamToArrayList {
  public static <T> ArrayList<T> streamToArrayList(Stream<T> stream, int size) {
    AtomicInteger count = new AtomicInteger();
    ArrayList<T> arrayList = new ArrayList<T>(size);
    stream.parallel().forEach((element)-> {
      int index = count.incrementAndGet();
      arrayList.add(index - 1, element);
    });
    return arrayList;
  }

  public static void main(String[] args) {
    ArrayList<String> wordList = streamToArrayList(Stream.of("panda", "Giant panda", "Lesser panda"), 3);
    for(String word: wordList) {
      System.out.println(word);
    }
  }

}
