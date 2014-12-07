package ch05.ex05_01;

import java.time.LocalDate;
import java.time.Period;

public class ProgrammerDay {

  /**
   * Calculate Programmer day for specified year using plusDays()
   * @param year Programmer day for this is calculated
   * @return Programmer day for specified year
   */
  public static LocalDate getProgrammersDayPlusDays(int year) {
    return LocalDate.of(year, 1, 1).plusDays(255);
  }

  /**
   * Calculate Programmer day for specified year without plusDays()
   * @param year Programmer day for this is calculated
   * @return Programmer day for specified year
   */
  public static LocalDate getProgrammersDayNoPlusDays(int year) {
    return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
  }

}
