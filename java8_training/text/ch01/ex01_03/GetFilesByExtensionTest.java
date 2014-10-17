package ch01.ex01_03;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.Test;

public class GetFilesByExtensionTest {

  @Test
  public void compareSizeFilenameFilterToLambda() {
    LinkedList<File> listFilenameFilter = new LinkedList<File>();
    GetFilesByExtension.getFilesByExtensionFilenameFilter(listFilenameFilter, System.getProperty("user.dir"), ".java");

    LinkedList<File> listLambda = new LinkedList<File>();
    GetFilesByExtension.getFilesByExtensionLambda(listLambda, System.getProperty("user.dir"), ".java");

    assertEquals(listFilenameFilter.size(), listLambda.size());
  }

  @Test
  public void checkThisPackageIncluded() {
    LinkedList<File> listLambda = new LinkedList<File>();
    GetFilesByExtension.getFilesByExtensionLambda(listLambda, System.getProperty("user.dir"), ".java");

    boolean isClassFound = false;
    boolean isTestFound = false;

    for(File oneFile: listLambda) {
      if (oneFile.getName().equals("GetFilesByExtension.java")) {
        isClassFound = true;
      }
      if (oneFile.getName().equals("GetFilesByExtensionTest.java")) {
        isTestFound = true;
      }
    }

    assertTrue(isClassFound);
    assertTrue(isTestFound);
  }

}
