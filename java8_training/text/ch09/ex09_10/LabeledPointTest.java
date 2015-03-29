package ch09.ex09_10;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabeledPointTest {

  @Test
  public void test() {
    LabeledPoint base = new LabeledPoint("Panda", 1, 2);
    assertTrue(base.equals(new LabeledPoint("Panda", 1, 2)));
    assertFalse(base.equals(new LabeledPoint("Panda", 5, 5)));
    int hash = base.hashCode();
    assertTrue(hash > Integer.MIN_VALUE);
    assertTrue(hash < Integer.MAX_VALUE);

    assertTrue(0 < base.compareTo(new LabeledPoint("Oanda", 1, 2)));
    assertTrue(0 > base.compareTo(new LabeledPoint("Qanda", 1, 2)));
    assertTrue(0 < base.compareTo(new LabeledPoint("Panda", 0, 2)));
    assertTrue(0 > base.compareTo(new LabeledPoint("Panda", 5, 2)));
    assertTrue(0 < base.compareTo(new LabeledPoint("Panda", 1, 0)));
    assertTrue(0 > base.compareTo(new LabeledPoint("Panda", 1, 5)));
    assertTrue(0 == base.compareTo(new LabeledPoint("Panda", 1, 2)));
  }

}
