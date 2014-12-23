package ch05.ex05_10;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class CalculateArrivalTimeTest {

  @Test
  public void test() {
    ZonedDateTime departure = ZonedDateTime.of(2014, 12, 23, 3, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
    Duration flightTime = Duration.ofMinutes(60*10 + 50);
    ZonedDateTime arrival = CalculateArrivalTime.calculateArrivalTime(departure, flightTime, ZoneId.of("CET"));
    ZonedDateTime expected = ZonedDateTime.of(2014, 12, 23, 22, 55, 0, 0, ZoneId.of("CET"));
    assertEquals(expected, arrival);
  }

}
