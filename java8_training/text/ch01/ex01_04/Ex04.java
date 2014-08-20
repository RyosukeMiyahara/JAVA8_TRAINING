package ch01.ex01_04;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Ex04 {

  public static void sortFileArrayComparator(File[] files) {
    Arrays.sort(files, new Comparator<File>() {
      @Override
      public int compare(File first, File second) {
        if (first.isDirectory() && !second.isDirectory()) {
          return -1;
        } else if (!first.isDirectory() && second.isDirectory()) {
          return 1;
        } else {
          return first.compareTo(second);
        }
      }
    });
  }

  public static void sortFileArrayLambda(File[] files) {
    Arrays.sort(files, (first, second) -> {
      if (first.isDirectory() && !second.isDirectory()) {
        return -1;
      } else if (!first.isDirectory() && second.isDirectory()) {
        return 1;
      } else {
        return first.compareTo(second);
      }
    });
  }

  public static void getSubDirectoryFiles(ArrayList<File> list, File directoryPath) {
    File[] files = directoryPath.listFiles();
    for (File oneFile: files) {
      list.add(oneFile);
      if (oneFile.isDirectory()) {
        getSubDirectoryFiles(list, oneFile);
      }
    }

  }

  public static void main(String[] args) {
    ArrayList<File> list = new ArrayList<File>();
    // getSubDirectoryFiles(list, new File("D:\\10_development\\git\\java8_training"));
    getSubDirectoryFiles(list, new File("C:\\home\\miyahara\\90_warehouse\\01_git\\JAVA8_TRAINING"));
    File[] fileArray = new File[list.size()];

    for(int i = 0; i < list.size(); i++) {
      fileArray[i] = list.get(i);
    }

    System.out.println(" --- Before sort --- ");
    for(File oneFile: fileArray) {
      System.out.println(oneFile);
    }
    System.out.println("");

    // sortFileArrayComparator(fileArray);
    sortFileArrayLambda(fileArray);

      System.out.println(" --- After sort --- ");
    for(File oneFile: fileArray) {
      System.out.println(oneFile);
    }
  }

}
