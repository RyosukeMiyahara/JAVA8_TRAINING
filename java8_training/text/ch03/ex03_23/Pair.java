package ch03.ex03_23;

import java.util.function.Function;

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

  public static <U, R> Pair<R> map(Pair<U> pair, Function<U, R> function) {
    return new Pair<R>(function.apply(pair.getFirst()), function.apply(pair.getSecond()));
  }
}
