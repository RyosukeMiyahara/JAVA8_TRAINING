package ch01.ex01_01;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
  public int compare(String first, String second) {
    System.out.println("Thread name of comparator; " + Thread.currentThread().getName());
    return Integer.compare(first.length(), second.length());
  }
}
