package ch05.ex05_09;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.stream.Stream;

public class FilteredTimeZoneOffset {

  /**
   * Show difference between UTC and all supported time zone
   */
  public static Stream<String> getShorterOffsetTimeZone(long offsetUpperMillis) {
    return ZoneId.getAvailableZoneIds().stream().filter((zoneId) -> {
      ZonedDateTime utc = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("UTC"));
      ZonedDateTime there = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of(zoneId));
      return Math.abs(Duration.between(utc, there).toMillis()) < offsetUpperMillis;
    });
  }

  public static void main(String[] args) {
    Stream<String> shorterOffsetTimeZone = getShorterOffsetTimeZone(1 * 60 * 60 * 1000);
    Iterator<String> iterator = shorterOffsetTimeZone.iterator();
    while(iterator.hasNext()) {
      String zoneId = iterator.next();
      ZonedDateTime utc = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("UTC"));
      ZonedDateTime there = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of(zoneId));
      Duration offset = Duration.between(utc, there);
      System.out.println(zoneId + ": " + offset);
    }
  }

}
