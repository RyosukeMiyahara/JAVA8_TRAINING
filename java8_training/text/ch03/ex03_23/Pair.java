package ch03.ex03_23;

import java.util.function.Function;

public class Pair<T> {
  private T first;
  private T second;
  /**
   * Constructor for Pair
   * @param first one object of pair
   * @param second the other object of pair
   */
  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Getter for first object
   * @return first object
   */
  public T getFirst() {
    return first;
  }

  /**
   * Getter for second object
   * @return second object
   */
  public T getSecond() {
    return second;
  }

  /**
   * Apply function to first and second object
   * @param function this is applied to first and second object
   * @return Pair whose elements are applied function
   */
  public <U> Pair<U> map(Function<T, U> function) {
    return new Pair<U>(function.apply(first), function.apply(second));
  }
}
