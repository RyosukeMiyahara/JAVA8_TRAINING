// TODO: テストコードを書く。。

package ch01.ex01_02;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;

public class Ex02 {
  public static void showSubDirectoriesFileFilter(LinkedList<File> list, String pathname) {
    File file = new File(pathname);
    FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    };
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      list.add(oneFile);
      showSubDirectoriesFileFilter(list, oneFile.toString());
    }
  }

  public static void showSubDirectoriesLambda(LinkedList<File> list, String pathname) {
    File file = new File(pathname);
    FileFilter directoryFilter = (File dummy) -> {return file.isDirectory();};
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      list.add(oneFile);
      showSubDirectoriesFileFilter(list, oneFile.toString());
    }
  }

  public static void showSubDirectoriesMethodReference(LinkedList<File> list, String pathname) {
    File file = new File(pathname);
    FileFilter directoryFilter = File::isDirectory;
    directoryFilter.accept(file);
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      list.add(oneFile);
      showSubDirectoriesFileFilter(list, oneFile.toString());
    }
  }

  public static boolean compareFileList(LinkedList<File> list1, LinkedList<File> list2) {
    if (list1.size() != list2.size()) {
      return false;
    }

    for (File oneFile: list1) {
      if (list2.indexOf(oneFile) == -1) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    LinkedList<File> listFileFilter = new LinkedList<File>();
    showSubDirectoriesFileFilter(listFileFilter, "D:\\10_development\\git\\java8_training");
    for(File oneFile: listFileFilter) {
      System.out.println(oneFile);
    }

    LinkedList<File> listLambda = new LinkedList<File>();
    showSubDirectoriesLambda(listLambda, "D:\\10_development\\git\\java8_training");
    for(File oneFile: listLambda) {
      System.out.println(oneFile);
    }

    LinkedList<File> listMethodReference = new LinkedList<File>();
    showSubDirectoriesMethodReference(listMethodReference, "D:\\10_development\\git\\java8_training");
    for(File oneFile: listMethodReference) {
      System.out.println(oneFile);
    }

    if (compareFileList(listFileFilter, listLambda)) {
      System.out.println("listFileFilter is the same as the listLambda");
    } else {
      System.out.println("listFileFilter is NOT the same as the listLambda");
    }

    if (compareFileList(listLambda, listMethodReference)) {
      System.out.println("listLambda is the same as the listMethodReference");
    } else {
      System.out.println("listLambda is NOT the same as the listMethodReference");
    }
  }
}
