package ch02.ex02_10;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class GetDoubleStreamAverageTest {

  @Test
  public void test() {
    Stream<Double> doubleStream = Stream.of(0.2, 0.4, 0.7, 0.7);
    double average = GetDoubleStreamAverage.getDoubleStreamAverage(doubleStream);
    if (average < 0.49 || 0.51 < average) {
      fail("average should be 0.5");
    }
  }

}
