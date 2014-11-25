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

  public <U> Pair<U> map(Function<T, U> function) {
    return new Pair<U>(function.apply(first), function.apply(second));
  }
}
