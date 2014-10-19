package ch02.ex02_08;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ZipStream {
  /**
   * Zip streams alternately.
   * When one stream empties, zipping stops.
   * @param first One zipped stream
   * @param second The other zipped stream
   * @return Zipped stream
   */
  @SuppressWarnings("unchecked")
  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    T[] firstArray = (T[])first.toArray();
    T[] secondArray = (T[])second.toArray();
    List<T> list = new LinkedList<T>();
    for (int i = 0; i < Math.min(firstArray.length, secondArray.length); i++) {
      list.add((T)firstArray[i]);
      list.add((T)secondArray[i]);
    }
    return list.stream();
  }

  public static void main(String[] args) {
    Stream<String> stream1 = Stream.of("1st", "2nd", "3rd", "4th", "5th", "6th");
    Stream<String> stream2 = Stream.of("Panda", "Giant panda", "Lesser panda");
    Stream<String> mixed = zip(stream1, stream2);
    mixed.forEach(line->System.out.println(line));
  }

}
