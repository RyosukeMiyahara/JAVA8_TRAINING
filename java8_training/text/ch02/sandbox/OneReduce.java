package ch02.sandbox;

import java.util.Optional;
import java.util.stream.Stream;

public class OneReduce {

  public static void main(String[] args) {
    Stream<Integer> value = Stream.of(5);
    Optional<Integer> sum = value.reduce((x,y) -> x + y);

    System.out.println(sum.get());
  }

}
