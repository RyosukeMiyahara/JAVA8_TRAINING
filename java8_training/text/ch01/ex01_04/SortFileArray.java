package ch01.ex01_04;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortFileArray {

  /**
   * Sort File array, as the following order, using Comparator
   *  - directory ordered by path name
   *  - file ordered by path name
   * @param files This array is sorted
   */
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

  /**
   * Sort File array, as the following order, using Lambda
   *  - directory ordered by path name
   *  - file ordered by path name
   * @param files This array is sorted
   */
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

  /**
   * Get sub directories and files under the specified path
   * @param list Found directories and files are added into this list
   * @param directoryPath Search target
   */
  public static void getSubDirectoryFiles(ArrayList<File> list, File directoryPath) {
    File[] files = directoryPath.listFiles();
    for (File oneFile: files) {
      list.add(oneFile);
      if (oneFile.isDirectory()) {
        getSubDirectoryFiles(list, oneFile);
      }
    }
  }

  /**
   * Convert File List into File Array
   * @param list This list converted into File Array
   */
  public static File[] convertFileListToFileArray(List<File> list) {
    File[] fileArray = new File[list.size()];
    for(int i = 0; i < list.size(); i++) {
      fileArray[i] = list.get(i);
    }
    return fileArray;
  }

  public static void main(String[] args) {
    ArrayList<File> list = new ArrayList<File>();
    getSubDirectoryFiles(list, new File("D:\\10_development\\git\\java8_training"));
    // getSubDirectoryFiles(list, new File("C:\\home\\miyahara\\90_warehouse\\01_git\\JAVA8_TRAINING"));
    File[] fileArray = convertFileListToFileArray(list);

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
