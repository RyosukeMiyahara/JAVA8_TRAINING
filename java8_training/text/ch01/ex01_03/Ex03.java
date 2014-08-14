package ch01.ex01_03;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.LinkedList;

public class Ex03 {

  public static void getFilesByExtensionFilenameFilter(LinkedList<File> list, String directoryPath, String extension) {
    File file = new File(directoryPath);
    FilenameFilter extensionFilter = new FilenameFilter() {
      @Override
      public boolean accept(File file, String name) {
        return name.endsWith(extension);
      }
    };
    String[] files = file.list(extensionFilter);
    for(String oneFile: files) {
      list.add(new File(directoryPath + System.getProperty("file.separator") + oneFile));
    }

    FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    File[] directories = file.listFiles(directoryFilter);
    for(File oneFile: directories) {
      getFilesByExtensionFilenameFilter(list, oneFile.toString(), extension);
    }
  }

  public static void getFilesByExtensionLambda(LinkedList<File> list, String directoryPath, String extension) {
    File file = new File(directoryPath);
    FilenameFilter extensionFilter = (path, name) -> {return name.endsWith(extension);};
    String[] files = file.list(extensionFilter);
    for(String oneFile: files) {
      list.add(new File(directoryPath + System.getProperty("file.separator") + oneFile));
    }

    FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    File[] directories = file.listFiles(directoryFilter);
    for(File oneFile: directories) {
      getFilesByExtensionLambda(list, oneFile.toString(), extension);
    }
  }

  public static void main(String[] args) {
    LinkedList<File> listFilenameFilter = new LinkedList<File>();
    getFilesByExtensionFilenameFilter(listFilenameFilter, "D:\\10_development\\git\\java8_training", ".java");
    for(File oneFile: listFilenameFilter) {
      System.out.println(oneFile);
    }

    System.out.println("");

    LinkedList<File> listLambda = new LinkedList<File>();
    getFilesByExtensionLambda(listLambda, "D:\\10_development\\git\\java8_training", ".java");
    for(File oneFile: listLambda) {
      System.out.println(oneFile);
    }
  }

}
