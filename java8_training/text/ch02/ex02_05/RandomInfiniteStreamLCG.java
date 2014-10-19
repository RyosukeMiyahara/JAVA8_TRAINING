package ch02.ex02_05;

import java.util.Iterator;
import java.util.stream.Stream;

public class RandomInfiniteStreamLCG {

  /**
   * Create infinite random stream using linear congruential generators
   * @param a for "xn+1 = (a xn + c)%m
   * @param c for "xn+1 = (a xn + c)%m
   * @param m for "xn+1 = (a xn + c)%m
   * @param seed x0 = seed
   * @return created infinite random stream
   */
  public static Stream<Long> randomInfiniteStreamLCG(long a, long c, long m, long seed) {
    Stream<Long> stream = Stream.iterate(seed, n->(a*n + c)%m);
    return stream;
  }

  public static void main(String[] args) {
    Stream<Long> randomStream = randomInfiniteStreamLCG(25214903917L, 11L, (long)Math.pow(2, 48), 0);
    Iterator<Long> iterator = randomStream.iterator();
    for (int i = 0; i < 10; i++) {
      System.out.println(iterator.next());
    }
  }

}
