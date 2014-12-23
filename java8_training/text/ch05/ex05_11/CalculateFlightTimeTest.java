package ch05.ex05_11;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class CalculateFlightTimeTest {

  @Test
  public void calculateArrivalTimeTest() {
    ZonedDateTime departure = ZonedDateTime.of(2014, 12, 23, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
    Duration flightTime = Duration.ofMinutes(60*10 + 50);
    ZonedDateTime arrival = CalculateFlightTime.calculateArrivalTime(departure, flightTime, ZoneId.of("CET"));
    ZonedDateTime expected = ZonedDateTime.of(2014, 12, 23, 22, 55, 0, 0, ZoneId.of("CET"));
    assertEquals(expected, arrival);
  }

  @Test
  public void calculateFlightTimeTest() {
    ZonedDateTime departure = ZonedDateTime.of(2014, 12, 23, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
    ZonedDateTime arrival = ZonedDateTime.of(2014, 12, 23, 22, 55, 0, 0, ZoneId.of("CET"));
    Duration flightTime = CalculateFlightTime.calculateFlightTime(departure, arrival);
    Duration expected = Duration.ofMinutes(10*60 + 50);
    assertEquals(expected, flightTime);
  }

}
