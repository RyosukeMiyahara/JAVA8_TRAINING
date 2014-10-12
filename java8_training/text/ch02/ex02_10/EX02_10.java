package ch02.ex02_10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EX02_10 {
  public static double getDoubleStreamAverage(Stream<Double> doubleStream) {
    double result;
    AtomicInteger count = new AtomicInteger();
    result = doubleStream.reduce(
        0.0,
        (first, second)->{count.incrementAndGet(); return first + second;});
    return result/(double)count.get();
  }

  public static void main(String[] args) {
    Stream<Double> doubleStream = Stream.of(0.2, 0.4, 0.7, 0.7);
    System.out.println(getDoubleStreamAverage(doubleStream));
  }

}
