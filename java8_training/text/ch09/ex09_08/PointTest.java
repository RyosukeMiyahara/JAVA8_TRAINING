package ch09.ex09_08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

  @Test
  public void test() {
    Point base = new Point(5, 5);
    assertTrue(0 < base.compareTo(new Point(4, 5)));
    assertTrue(0 > base.compareTo(new Point(6, 5)));
    assertTrue(0 < base.compareTo(new Point(5, 4)));
    assertTrue(0 > base.compareTo(new Point(5, 6)));
    assertTrue(0 == base.compareTo(new Point(5, 5)));
    Point bigBase = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
    assertTrue(0 < bigBase.compareTo(new Point(1, 1)));
  }

}
