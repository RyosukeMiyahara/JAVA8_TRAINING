package ch03.ex03_01;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

public class DeferredLoggerTest {

  @Test
  public void deferredLoggerTest() {
    String a[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    DeferredLogger.setLoggerLevel(Level.FINE);

    assertEquals(0, DeferredLogger.getAssessingCount());

    int i = 10;
    DeferredLogger.logInfo(Level.INFO, () -> i == 10, () -> "A[10] = " + a[10]);

    assertEquals(1, DeferredLogger.getAssessingCount());

    int j = 5;
    DeferredLogger.logInfo(Level.FINEST, () -> j == 10, () -> "A[10] = " + a[10]);

    assertEquals(1, DeferredLogger.getAssessingCount());
  }

}
