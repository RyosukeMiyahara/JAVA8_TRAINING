package ch03.ex03_18;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UncheckedTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void uncheckedTest() {
    String[] strings = {"panda"};
    try {
      Unchecked.unchecked((String string) -> {
        strings[0] = string;
        throw new Exception(string);
      }).apply("Giant panda");
    } catch (Exception e) {
      e.printStackTrace();
      assertEquals("Giant panda", strings[0]);
      assertEquals("Giant panda", e.getCause().getMessage());
    }
  }
}
