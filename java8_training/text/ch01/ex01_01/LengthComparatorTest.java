/**
 *
 */
package ch01.ex01_01;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Ryosuke Miyahara
 *
 */
public class LengthComparatorTest {

  @Test
  public void test() {
    String testData[] = {"4444", "55555", "22", "1", "333"};
    String expected[] = {"1", "22", "333", "4444", "55555"};
    Arrays.sort(testData, new LengthComparator());
    for (int i = 0; i < expected.length; i++) {
      if (!testData[i].equals(expected[i])) {
        fail("testData[" + i + "] does not match");
      }
    }
  }

}
