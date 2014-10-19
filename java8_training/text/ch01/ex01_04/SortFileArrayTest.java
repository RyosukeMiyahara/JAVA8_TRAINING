package ch01.ex01_04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class SortFileArrayTest {

  @Test
  public void getSubDirectoryFilesTest() {
    ArrayList<File> list = new ArrayList<File>();
    SortFileArray.getSubDirectoryFiles(list, new File(System.getProperty("user.dir")));
    boolean isFileFound = false;
    boolean isDirectoryFound = false;
    for (File oneFile : list) {
      if (oneFile.getName().equals("SortFileArray.java")) {
        isFileFound = true;
      }
      if (oneFile.getName().equals("ex01_02")) {
        isDirectoryFound = true;
      }
    }
    assertTrue(isFileFound);
    assertTrue(isDirectoryFound);
  }

  @Test
  public void sortFileArrayComparatorTest() {
    ArrayList<File> list = new ArrayList<File>();
    SortFileArray.getSubDirectoryFiles(list, new File(System.getProperty("user.dir")));
    File[] fileArray = SortFileArray.convertFileListToFileArray(list);
    SortFileArray.sortFileArrayComparator(fileArray);

    int lastDirectoryIndex = 0;
    boolean isFileFound = false;

    for (int i = 0; i < fileArray.length; i++) {
      if (!fileArray[i].isDirectory()) {
        isFileFound = true;
        lastDirectoryIndex = i - 1;
      }
      if (isFileFound) {
        if (fileArray[i].isDirectory()) {
          fail("Directory is found after file");
        }
      }
    }
    assertTrue(isFileFound);

    if (lastDirectoryIndex > 0) {
      if (fileArray[0].compareTo(fileArray[lastDirectoryIndex]) > 0) {
        fail("Sort in directory group is incorrect");
      }
    }

    if ((fileArray.length - lastDirectoryIndex) >= 2) {
      if (fileArray[lastDirectoryIndex + 1].compareTo(fileArray[fileArray.length - 1]) > 0) {
        fail("Sort in file group is incorrect");
      }
    }
  }

  @Test
  public void sortFileArrayLambdaTest() {
    ArrayList<File> list = new ArrayList<File>();
    SortFileArray.getSubDirectoryFiles(list, new File(System.getProperty("user.dir")));
    File[] fileArray = SortFileArray.convertFileListToFileArray(list);
    SortFileArray.sortFileArrayLambda(fileArray);

    int lastDirectoryIndex = 0;
    boolean isFileFound = false;

    for (int i = 0; i < fileArray.length; i++) {
      if (!fileArray[i].isDirectory()) {
        isFileFound = true;
        lastDirectoryIndex = i - 1;
      }
      if (isFileFound) {
        if (fileArray[i].isDirectory()) {
          fail("Directory is found after file");
        }
      }
    }
    assertTrue(isFileFound);

    if (lastDirectoryIndex > 0) {
      if (fileArray[0].compareTo(fileArray[lastDirectoryIndex]) > 0) {
        fail("Sort in directory group is incorrect");
      }
    }

    if ((fileArray.length - lastDirectoryIndex) >= 2) {
      if (fileArray[lastDirectoryIndex + 1].compareTo(fileArray[fileArray.length - 1]) > 0) {
        fail("Sort in file group is incorrect");
      }
    }
  }

}
