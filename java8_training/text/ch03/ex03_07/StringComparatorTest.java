package ch03.ex03_07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StringComparatorTest {
  String[] strings = new String[4];

  @Before
  public void setUp() throws Exception {
    strings[0] = "panda";
    strings[1] = "PANDA";
    strings[2] = " panda";
    strings[3] = "panda";
  }

  @Test
  public void ascCaseSensitiveIgnoreSpaceCaseTest() {
    String[] expected = {"PANDA", "panda", " panda", "panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(true, true, true));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void descCaseSensitiveIgnoreSpaceCaseTest() {
    String[] expected = {"panda", " panda", "panda", "PANDA"};
    Arrays.sort(strings, StringComparator.generateStringComparator(false, true, true));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void ascNoCaseSensitiveIgnoreSpaceCaseTest() {
    String[] expected = {"panda", "PANDA", " panda", "panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(true, false, true));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void descNoCaseSensitiveIgnoreSpaceCaseTest() {
    String[] expected = {"panda", "PANDA", " panda", "panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(false, false, true));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void ascCaseSensitiveNoIgnoreSpaceCaseTest() {
    String[] expected = {" panda", "PANDA", "panda", "panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(true, true, false));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void descCaseSensitiveNoIgnoreSpaceCaseTest() {
    String[] expected = {"panda", "panda", "PANDA", " panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(false, true, false));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void ascNoCaseSensitiveNoIgnoreSpaceCaseTest() {
    String[] expected = {" panda", "panda", "PANDA", "panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(true, false, false));
    assertArrayEquals(expected, strings);
  }

  @Test
  public void descNoCaseSensitiveNoIgnoreSpaceCaseTest() {
    String[] expected = {"panda", "PANDA", "panda", " panda"};
    Arrays.sort(strings, StringComparator.generateStringComparator(false, false, false));
    assertArrayEquals(expected, strings);
  }

}
