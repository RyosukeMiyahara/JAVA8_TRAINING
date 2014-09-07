package ch02.ex02_10;

import java.util.stream.Stream;

public class EX02_10 {
  public static double getDoubleStreamAverage(Stream<Double> doubleStream) {
    double result;
    // long streamCount = doubleStream.count();
    // long streamCount = 1;
    result = doubleStream.reduce(
        0.0,
        (first, second)->first + second,
        (total1, total2)->(total1 * total2)/3);
      // return total1;
    return result;
  }

  public static void main(String[] args) {
    Stream<Double> doubleStream = Stream.of(0.2, 0.4, 0.7, 0.7);
    System.out.println(getDoubleStreamAverage(doubleStream));
  }

}
