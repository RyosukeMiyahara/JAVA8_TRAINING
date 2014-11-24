package ch04.ex04_05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.value.ObservableValue;

public class ObservableValueMod {
  public static  <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {

  }

  public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {

  }
}
