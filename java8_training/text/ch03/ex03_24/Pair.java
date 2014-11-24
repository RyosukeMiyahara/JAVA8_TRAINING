package ch03.ex03_24;

import java.util.function.Function;
import java.util.stream.Stream;

public class Pair<T> {
  private T first;
  private T second;
  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  public <U> Stream<U> flatMap(Function<? super T, ? extends Stream<? extends U>> mapper) {
    return Stream.concat(mapper.apply(first), mapper.apply(second));
  }
}
