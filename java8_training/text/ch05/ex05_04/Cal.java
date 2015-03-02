package ch05.ex05_04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;

public class Cal {

  /**
   * Return formartted calender as String list
   * @param month
   * @param year
   * @return Formartted calender as String list
   * @exception throw IllegalArgumentException when invalid month is specified
   */
  public static LinkedList<String> getCalStrings(int month, int year) {
    if (month < 1 || 12 < month) {
      throw new IllegalArgumentException("Specified month is " + month);
    }

    LocalDate day = LocalDate.of(year, month, 1);
    LinkedList<String> result = new LinkedList<String>();
    StringBuilder week = new StringBuilder();
    for (int i = 0; i < day.getDayOfWeek().getValue() - 1; i++) {
      week.append("   ");
    }
    while(day.getMonth().getValue() == month) {
      week.append(String.format("%1$3d", day.getDayOfMonth()));
      day = day.plusDays(1);
      if (day.getDayOfWeek() == DayOfWeek.MONDAY || day.getMonth().getValue() != month) {
        result.add(week.toString());
        week.delete(0, week.length());
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int month = Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[1]);
    LinkedList<String> calList = getCalStrings(month, year);
    for(String week: calList) {
      System.out.println(week);
    }
  }

}
