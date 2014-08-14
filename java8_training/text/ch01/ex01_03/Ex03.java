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

  public static void main(String[] args) {
    LinkedList<File> list = new LinkedList<File>();
    getFilesByExtensionFilenameFilter(list, "D:\\10_development\\git\\java8_training", ".java");
    for(File oneFile: list) {
      System.out.println(oneFile);
    }
  }

}
