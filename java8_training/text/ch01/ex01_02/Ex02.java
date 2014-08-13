// TODO: 文字列を表示するのではなく、ディレクトリを返すようにする

package ch01.ex01_02;

import java.io.File;
import java.io.FileFilter;

public class Ex02 {
  public static void showSubDirectoriesFileFilter(String pathname, int depth) {
    File file = new File(pathname);
    FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    };
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      for (int i = 0; i < depth; i++) {
        System.out.print("-");
      }
      System.out.println(oneFile);
      showSubDirectoriesFileFilter(oneFile.toString(), depth + 1);
    }
  }

  public static void showSubDirectoriesLambda(String pathname, int depth) {
    File file = new File(pathname);
    FileFilter directoryFilter = (File dummy) -> {return file.isDirectory();};
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      for (int i = 0; i < depth; i++) {
        System.out.print("-");
      }
      System.out.println(oneFile);
      showSubDirectoriesFileFilter(oneFile.toString(), depth + 1);
    }
  }

  public static void showSubDirectoriesMethodReference(String pathname, int depth) {
    File file = new File(pathname);
    FileFilter directoryFilter = File::isDirectory;
    directoryFilter.accept(file);
    File[] files = file.listFiles(directoryFilter);
    for(File oneFile: files) {
      for (int i = 0; i < depth; i++) {
        System.out.print("-");
      }
      System.out.println(oneFile);
      showSubDirectoriesFileFilter(oneFile.toString(), depth + 1);
    }
  }

  public static void main(String[] args) {
    showSubDirectoriesFileFilter("D:\\10_development\\git\\java8_training", 0);

    System.out.println("");

    showSubDirectoriesLambda("D:\\10_development\\git\\java8_training", 0);

    System.out.println("");

    showSubDirectoriesMethodReference("D:\\10_development\\git\\java8_training", 0);
  }
}
