package ch01.ex01_02;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;

public class Ex02 {
  public static void getSubDirectoriesFileFilter(LinkedList<File> list, String directoryPath) {
    File file = new File(directoryPath);
    FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    };
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      list.add(oneFile);
      getSubDirectoriesFileFilter(list, oneFile.toString());
    }
  }

  public static void getSubDirectoriesLambda(LinkedList<File> list, String directoryPath) {
    System.out.println(directoryPath);
    File file = new File(directoryPath);
    FileFilter directoryFilter = (pathname) -> {return pathname.isDirectory();};
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      list.add(oneFile);
      getSubDirectoriesLambda(list, oneFile.toString());
    }
  }

  public static void getSubDirectoriesMethodReference(LinkedList<File> list, String directoryPath) {
    File file = new File(directoryPath);
    FileFilter directoryFilter = File::isDirectory;
    directoryFilter.accept(file);
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      list.add(oneFile);
      getSubDirectoriesMethodReference(list, oneFile.toString());
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
    getSubDirectoriesFileFilter(listFileFilter, "D:\\10_development\\git\\java8_training");
    for(File oneFile: listFileFilter) {
      // System.out.println(oneFile);
    }

    LinkedList<File> listLambda = new LinkedList<File>();
    getSubDirectoriesLambda(listLambda, "D:\\10_development\\git\\java8_training");
    for(File oneFile: listLambda) {
      System.out.println(oneFile);
    }

    LinkedList<File> listMethodReference = new LinkedList<File>();
    getSubDirectoriesMethodReference(listMethodReference, "D:\\10_development\\git\\java8_training");
    for(File oneFile: listMethodReference) {
      System.out.println(oneFile);
    }

    if (compareFileList(listFileFilter, listLambda)) {
      System.out.println("listFileFilter is the same as the listLambda");
    } else {
      System.out.println("listFileFilter is NOT the same as the listLambda");
    }

    if (compareFileList(listFileFilter, listMethodReference)) {
      System.out.println("listLambda is the same as the listMethodReference");
    } else {
      System.out.println("listLambda is NOT the same as the listMethodReference");
    }
  }
}
