package ch05.ex05_03;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class TemporalAdjusterImplTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void temporalAdjusterImplTest() {
    LocalDate expected = LocalDate.now();
    while(true) {
      expected = expected.plusDays(1);
      if (expected.getDayOfWeek().getValue() < 6) {
        break;
      }
    }
    LocalDate today = LocalDate.now();
    assertEquals(expected, (today.with(TemporalAdjusterImpl.next(w -> w.getDayOfWeek().getValue() < 6))));
  }
}
