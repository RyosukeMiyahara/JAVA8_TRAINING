package ch03.ex03_20;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListMap {
  /**
   * Map function for list
   * @param list list to be mapped
   * @param function this is applied to each map element
   * @return list which is composed of provided list whose element is applied function
   */
  public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
    return list.stream().map(function).collect(Collectors.toList());
  }
}
