package ch03.ex03_20;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListMap {
  public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
    return list.stream().map(function).collect(Collectors.toList());
  }
}
