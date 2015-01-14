package ch06.ex06_08;

import java.util.Arrays;

public class CompareArraysSort {

  public static void main(String[] args) {

    long start = 0;
    long end = 0;
    long sortResult = 0;
    long parallelSortResult = 0;

    for (int i = 1; i < 100; i++) {
      // Prepare array and result variables
      start = 0;
      end = 0;
      sortResult = 0;
      parallelSortResult = 0;
      String[] pandas = new String[i * 3];

      // For sort()
      for (int j = 0; j < i * 3; j = j + 3) {
        pandas[j] = "panda";
        pandas[j + 1] = "giant panda";
        pandas[j + 2] = "lesser panda";
      }
      start = System.nanoTime();
      Arrays.sort(pandas);
      end = System.nanoTime();
      sortResult = end - start;

      // For parallelSort()
      start = 0;
      end = 0;
      for (int j = 0; j < i * 3; j = j + 3) {
        pandas[j] = "panda";
        pandas[j + 1] = "giant panda";
        pandas[j + 2] = "lesser panda";
      }
      start = System.nanoTime();
      Arrays.parallelSort(pandas);
      end = System.nanoTime();
      parallelSortResult = end - start;

      if (parallelSortResult > sortResult) {
        System.out.println("When String array size is " + i * 3 + ", parallelSort() is faster than sort()");
        break;
      }
    }
  }

}
