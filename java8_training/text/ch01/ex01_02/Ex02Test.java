package ch01.ex01_02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.Test;

public class Ex02Test {

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
    if (!Ex02.compareFileList(list1, list2)) {
      fail("list1とlist2は同じ内容のはずです。");
    }
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

    if (Ex02.compareFileList(list1, list2)) {
      fail("list1とlist2の内容は異なるはずです。");
    }
  }

  @Test
  public void testShowSubDirectoriesFileFilter() {
    fail("まだ実装されていません");
  }

  @Test
  public void testShowSubDirectoriesLambda() {
    fail("まだ実装されていません");
  }

  @Test
  public void testShowSubDirectoriesMethodReference() {
    fail("まだ実装されていません");
  }



}
