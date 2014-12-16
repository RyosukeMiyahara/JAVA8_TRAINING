package ch05.ex05_04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class CalTest {

  @Test
  public void successTest() {
    String[] expected = {
        "              1  2  3",
        "  4  5  6  7  8  9 10",
        " 11 12 13 14 15 16 17",
        " 18 19 20 21 22 23 24",
        " 25 26 27 28 29 30 31"
    };
    LinkedList<String> calList = Cal.getCalStrings(3, 2013);
    assertArrayEquals(expected, calList.toArray());
  }

  @Test
  public void smallMonthTest() {
    try {
      Cal.getCalStrings(0, 2013);
      fail("IllegalArgumentException is expected");
    } catch(Exception e) {
      assertThat(e, instanceOf(IllegalArgumentException.class));
    }
  }

  @Test
  public void greaterMonthTest() {
    try {
      Cal.getCalStrings(13, 2013);
      fail("IllegalArgumentException is expected");
    } catch(Exception e) {
      assertThat(e, instanceOf(IllegalArgumentException.class));
    }
  }
}
