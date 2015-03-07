package ch08.ex08_09;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.Test;

public class ScannerConverterTest {

  @Test
  public void scannerConverterLinesTest() {
    ScannerConverter sc = null;
    try {
      sc = new ScannerConverter(new Scanner(new File("text/ch08/ex08_09/sampleWords.txt")));
    } catch (Exception e) {
      e.printStackTrace();
      fail("No test file");
    }

    Stream<String> stream = sc.lines();
    String[] expected = { "panda line1", "panda line2", "panda line3" };

    assertArrayEquals(expected, stream.toArray());
  }

  @Test
  public void scannerConverterWordsTest() {
    ScannerConverter sc = null;

    try {
      sc = new ScannerConverter(new Scanner(new File("text/ch08/ex08_09/sampleWords.txt")));
    } catch (Exception e) {
      e.printStackTrace();
      fail("No test file");
    }

    Stream<String> stream = sc.words();
    String[] expected = { "panda", "line1", "panda", "line2", "panda", "line3" };

    assertArrayEquals(expected, stream.toArray());
  }

  @Test
  public void scannerConverterIntsTest() {
    ScannerConverter sc = null;

    try {
      sc = new ScannerConverter(new Scanner(new File("text/ch08/ex08_09/intSample.txt")));
    } catch (Exception e) {
      e.printStackTrace();
      fail("No test file");
    }

    Stream<Integer> intStream = sc.ints();
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    assertArrayEquals(expected, intStream.toArray());
  }

  @Test
  public void scannerConverterDoublesTest() {
    ScannerConverter sc;

    try {
      sc = new ScannerConverter(new Scanner(new File("text/ch08/ex08_09/doubleSample.txt")));
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    Stream<Double> doubleStream = sc.doubles();
    Double[] expected = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};

    assertArrayEquals(expected, doubleStream.toArray());

  }
}
