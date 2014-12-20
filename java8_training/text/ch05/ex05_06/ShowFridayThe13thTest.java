package ch05.ex05_06;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.Test;

public class ShowFridayThe13thTest {

  @Test
  public void getFridayThe13thTest() {
    LinkedList<LocalDate> fridays = ShowFridayThe13th.getFridayThe13th(LocalDate.of(1901, 1, 1), LocalDate.now());
    assertTrue(fridays.size() > 0);
    for (LocalDate d: fridays) {
      assertEquals(13, d.getDayOfMonth());
      assertEquals(DayOfWeek.FRIDAY, d.getDayOfWeek());
    }
  }

}
