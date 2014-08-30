package ch02.ex02_05;

import java.util.Iterator;
import java.util.stream.Stream;

public class EX02_05 {

  public static Stream<Long> randomInfiniteStream(long a, long c, long m, long seed) {
    Stream<Long> stream = Stream.iterate(seed, n->(a*n + c)%m);
    return stream;
  }

  public static void main(String[] args) {
    Stream<Long> randomStream = randomInfiniteStream(25214903917L, 11L, (long)Math.pow(2, 48), 0);
    Iterator<Long> iterator = randomStream.iterator();
    for (int i = 0; i < 10; i++) {
      System.out.println(iterator.next());
    }
  }

}
