package ch08.ex08_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathGeneratorCheckTest {

  @Test
  public void test() {
    assertEquals(11, MathGeneratorCheck.next(0));
    assertEquals(164311266871034L, MathGeneratorCheck.prev(MathGeneratorCheck.prev(MathGeneratorCheck.prev(0)))^25214903917L);
  }

}
