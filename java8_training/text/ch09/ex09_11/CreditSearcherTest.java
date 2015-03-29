package ch09.ex09_11;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class CreditSearcherTest {

  @Test
  public void test() {
    LinkedList<String> foundNumbers = CreditSearcher.searchCredit("text/ch09/ex09_11/testData");
    assertEquals(3, foundNumbers.size());
    boolean zero = false;
    boolean one = false;
    boolean two = false;
    for (String s: foundNumbers) {
      if (s.equals("0000-0000-0000-0000")) {
        zero = true;
      }
      if (s.equals("1111-1111-1111-1111")) {
        one = true;
      }
      if (s.equals("2222-2222-2222-2222")) {
        two = true;
      }
    }
    assertTrue(zero);
    assertTrue(one);
    assertTrue(two);
  }

}
