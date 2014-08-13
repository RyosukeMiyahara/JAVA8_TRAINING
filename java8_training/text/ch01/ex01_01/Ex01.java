package ch01.ex01_01;

import java.util.Arrays;

public class Ex01 {

  public static void showPandas(String[] pandas) {
    for (int i = 0; i < pandas.length; i++) {
      System.out.println(i + ": " + pandas[i]);
    }

  }

  public static void main(String[] args) {
    System.out.println("Main thread name: " + Thread.currentThread().getName());
    System.out.println("");
    String pandas[] = {"Lesser panda", "Panda", "Giant panda"};
    showPandas(pandas);
    System.out.println("");
    Arrays.sort(pandas, new LengthComparator());
    System.out.println("Sorted!");
    System.out.println("");
    showPandas(pandas);
  }
}
