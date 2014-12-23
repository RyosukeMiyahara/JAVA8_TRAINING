package ch05.ex05_11;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CalculateFlightTime {

  /**
   * Calculate arrival time from departure and flight time
   * @param departure departure time
   * @param flightTime flight time
   * @param dstZone ZoneId of destination
   * @return arrival time on destination timezone
   */
  public static ZonedDateTime calculateArrivalTime(ZonedDateTime departure, Duration flightTime, ZoneId dstZone) {
    ZonedDateTime result = departure.plus(flightTime);
    result = result.withZoneSameInstant(dstZone);
    return result;
  }

  /**
   * Calculate flight time from departure and arrival
   * @param departure departure time
   * @param arrival arrival time
   * @return flight time
   */
  public static Duration calculateFlightTime(ZonedDateTime departure, ZonedDateTime arrival) {
    return Duration.between(departure, arrival);
  }

  public static void main(String[] args) {
    ZonedDateTime departure = ZonedDateTime.of(2014, 12, 23, 14, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
    ZonedDateTime arrival = ZonedDateTime.of(2014, 12, 24, 16, 40, 0, 0, ZoneId.of("CET"));
    Duration flightTime = calculateFlightTime(departure, arrival);
    System.out.println("From LA to Frankfurt");
    System.out.println("Departure: " + departure.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")));
    System.out.println("Arrival: " + arrival.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")));
    System.out.println("Flight time: " + flightTime.toHours() + ":" + (flightTime.toMinutes() - flightTime.toHours()*60));
  }
}
