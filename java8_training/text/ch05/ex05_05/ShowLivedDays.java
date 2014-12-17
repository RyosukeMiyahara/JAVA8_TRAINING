package ch05.ex05_05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShowLivedDays {

  public static void main(String[] args) {
    LocalDate birthDay = LocalDate.of(1985, 10, 8);
    LocalDate today = LocalDate.now();
    System.out.println("Lived days from 1985/10/8 is " + birthDay.until(today, ChronoUnit.DAYS));
  }

}
