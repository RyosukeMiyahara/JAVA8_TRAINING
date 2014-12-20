package ch05.ex05_06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;

public class ShowFridayThe13th {

  /**
   * Get all Friday The 13th between specified start and end
   * @param start Search Friday The 13th from this
   * @param end Search Friday The 13th to this
   * @return List of Friday The 13th between specified start and end
   */
  public static LinkedList<LocalDate> getFridayThe13th(LocalDate start, LocalDate end) {
    // Search first friday from start
    while(true) {
      start = start.plusDays(1);
      if (start.getDayOfWeek() == DayOfWeek.FRIDAY) {
        break;
      }
    }

    // Search Friday The 13th from start to end
    LinkedList<LocalDate> friday13th = new LinkedList<LocalDate>();
    while(start.isBefore(end)) {
      if (start.getDayOfMonth() == 13) {
        friday13th.add(start);
      }
      start = start.plusWeeks(1);
    }

    return friday13th;
  }

  public static void main(String[] args) {
    LinkedList<LocalDate> fridays = getFridayThe13th(LocalDate.of(1901, 1, 1), LocalDate.now());
    for (LocalDate d: fridays) {
      System.out.println(d);
    }
  }

}
