package ch01.ex01_02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.Test;

public class GetSubDirectoriesTest {

  @Test
  public void testCompareFileListMatch() {
    File file1 = new File("file1");
    File file2 = new File("file2");

    LinkedList<File> list1 = new LinkedList<File>();
    LinkedList<File> list2 = new LinkedList<File>();

    list1.add(file1);
    list1.add(file2);
    list2.add(file1);
    list2.add(file2);
    assertTrue(GetSubDirectories.compareFileList(list1, list2));
  }

  @Test
  public void testCompareFileListNoMatch() {
    File file1 = new File("file1");
    File file2 = new File("file2");
    File file3 = new File("file3");

    LinkedList<File> list1 = new LinkedList<File>();
    LinkedList<File> list2 = new LinkedList<File>();

    list1.add(file1);
    list1.add(file2);

    list2.add(file1);
    list2.add(file3);

    assertFalse(GetSubDirectories.compareFileList(list1, list2));
  }

  @Test
  public void testGetSubDirectoriesFileFilter() {
    LinkedList<File> list = new LinkedList<File>();
    GetSubDirectories.getSubDirectoriesFileFilter(list, System.getProperty("user.dir"));
    boolean isEx01_02Found = false;
    boolean isReadmeFound = false;
    for(File oneFile: list) {
      if (oneFile.toString().endsWith("ex01_02")) {
        isEx01_02Found = true;
      }
      if (oneFile.toString().endsWith("README.md")) {
        isReadmeFound = true;
      }
    }
    assertTrue(isEx01_02Found);
    assertFalse(isReadmeFound);
  }

  @Test
  public void testGetSubDirectoriesLambda() {
    LinkedList<File> listFileFilter = new LinkedList<File>();
    LinkedList<File> listLambda = new LinkedList<File>();
    GetSubDirectories.getSubDirectoriesFileFilter(listFileFilter, System.getProperty("user.dir"));
    GetSubDirectories.getSubDirectoriesLambda(listLambda, System.getProperty("user.dir"));
    assertTrue(GetSubDirectories.compareFileList(listFileFilter, listLambda));
  }

  @Test
  public void testGetSubDirectoriesMethodReference() {
    LinkedList<File> listFileFilter = new LinkedList<File>();
    LinkedList<File> listMethodReference = new LinkedList<File>();
    GetSubDirectories.getSubDirectoriesFileFilter(listFileFilter, System.getProperty("user.dir"));
    GetSubDirectories.getSubDirectoriesMethodReference(listMethodReference, System.getProperty("user.dir"));
    assertTrue(GetSubDirectories.compareFileList(listFileFilter, listMethodReference));
  }



}
