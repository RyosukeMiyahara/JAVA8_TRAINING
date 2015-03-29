package ch09.ex09_09;

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
  }

}
