package ch05.ex05_10;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CalculateArrivalTime {

  public static ZonedDateTime calculateArrivalTime(ZonedDateTime src, Duration flightTime, ZoneId dstZone) {
    ZonedDateTime result = src.plus(flightTime);
    result = result.withZoneSameInstant(dstZone);
    return result;
  }
  public static void main(String[] args) {
    ZonedDateTime departure = ZonedDateTime.of(2014, 12, 23, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
    Duration flightTime = Duration.ofMinutes(60*10 + 50);
    ZonedDateTime arrival = calculateArrivalTime(departure, flightTime, ZoneId.of("CET"));
    System.out.println("From LA to Frankfurt");
    System.out.println("Departure: " + departure.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")));
    System.out.println("Flight time: " + flightTime.toHours() + ":" + (flightTime.toMinutes() - flightTime.toHours()*60));

    System.out.println("Arrival: " + arrival.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")));
  }
}
