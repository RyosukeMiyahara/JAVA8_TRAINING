package ch05.ex05_08;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.stream.Stream;

public class ShowTimeZoneOffset {

  /**
   * Show difference between UTC and all supported time zone
   */
  public static void showTimeZoneOffset() {
    Stream<String> zonesStream = ZoneId.getAvailableZoneIds().stream();
    Iterator<String> iterator = zonesStream.iterator();
    while(iterator.hasNext()) {
      String zoneId = iterator.next();
      ZonedDateTime utc = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("UTC"));
      ZonedDateTime there = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of(zoneId));
      Duration offset = Duration.between(utc, there);
      System.out.println(zoneId + ": " + offset);
    }
  }

  public static void main(String[] args) {
    showTimeZoneOffset();
  }

}
