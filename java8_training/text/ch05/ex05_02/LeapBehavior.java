package ch05.ex05_02;

import java.time.LocalDate;

public class LeapBehavior {
  public static void main(String[] args) {
    System.out.println("2000/2/29 + 1 year:");
    System.out.println(LocalDate.of(2000, 2, 29).plusYears(1));

    System.out.println("");

    System.out.println("2000/2/29 + 4 year");
    System.out.println(LocalDate.of(2000, 2, 29).plusYears(4));


    System.out.println("");

    System.out.println("2000/2/29 + 1 year 4times");
    LocalDate leap1plus4times = LocalDate.of(2000, 2, 29);
    for (int i = 0; i < 4; i++) {
      leap1plus4times.plusYears(1);
    }
    System.out.println(leap1plus4times);
  }
}
