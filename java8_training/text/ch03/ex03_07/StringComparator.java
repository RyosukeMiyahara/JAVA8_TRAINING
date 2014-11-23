package ch03.ex03_07;

import java.util.Arrays;
import java.util.Comparator;

public class StringComparator {
  public static Comparator<String> generateStringComparator(boolean isAsc, boolean isCaseSensitive, boolean isIgnoreSpace) {
    return (first, second) -> {
      String firstFiltered = first;
      String secondFiltered = second;
      if (isIgnoreSpace) {
        firstFiltered = first.trim();
        secondFiltered = second.trim();
      }
      if (isCaseSensitive) {
        if (isAsc) {
          return firstFiltered.compareTo(secondFiltered);
        } else {
          return firstFiltered.compareTo(secondFiltered) * -1;
        }
      } else {
        if (isAsc) {
          return firstFiltered.compareToIgnoreCase(secondFiltered);
        } else {
          return firstFiltered.compareToIgnoreCase(secondFiltered) * -1;
        }
      }
    };
  }

  public static void main(String[] args) {
    String[] strings = {"aaa", "aAA","aaa"};
    Arrays.sort(strings, generateStringComparator(true, false, true));
    for (int i = 0; i < strings.length; i++) {
      System.out.println(strings[i]);
    }
  }

}
