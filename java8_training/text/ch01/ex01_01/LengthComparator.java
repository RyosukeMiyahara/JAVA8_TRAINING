package ch01.ex01_01;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

  /**
   * Compare provided strings.
   * To confirm who call this function, shown thread name.
   *
   * @param first first comparing target
   * @param second second comparing target
   * @return if first.length() ==second.length() return 0, if first.length() < second.length() return value greater
   *         than 0, if first.length() > second.length() return value less then 0
   */
  public int compare(String first, String second) {
    // Show thread name to confirm who sorts strings
    System.out.println("Thread name of comparator; " + Thread.currentThread().getName());

    return Integer.compare(first.length(), second.length());
  }
}
