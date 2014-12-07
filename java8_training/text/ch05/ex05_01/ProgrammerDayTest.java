package ch05.ex05_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProgrammerDayTest {

  @Test
  public void programmerDayTest() {
    assertEquals(ProgrammerDay.getProgrammersDayPlusDays(2014),
        ProgrammerDay.getProgrammersDayNoPlusDays(2014));
    assertEquals(ProgrammerDay.getProgrammersDayPlusDays(2015),
        ProgrammerDay.getProgrammersDayNoPlusDays(2015));
    assertEquals(ProgrammerDay.getProgrammersDayPlusDays(2000),
        ProgrammerDay.getProgrammersDayNoPlusDays(2000));
  }

}
