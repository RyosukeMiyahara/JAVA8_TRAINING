package ch05.ex05_12;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GlobalSchedulerTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    GlobalScheduler scheduler = new GlobalScheduler();
    ZonedDateTime schedule1 = ZonedDateTime.of(2014, 12, 15, 17, 0, 0, 0, ZoneId.of("MST7MDT"));
    ZonedDateTime schedule2 = ZonedDateTime.of(2014, 12, 16, 1, 0, 0, 0, ZoneId.of("Europe/Vatican"));
    ZonedDateTime schedule3 = ZonedDateTime.of(2014, 12, 16, 7, 0, 0, 0, ZoneId.of("Asia/Dubai"));
    scheduler.addSchedule(schedule1, "Schedule 1");
    scheduler.addSchedule(schedule2, "Schedule 2");
    scheduler.addSchedule(schedule3, "Schedule 3");

    ZonedDateTime localDatetime = ZonedDateTime.of(2014, 12, 16, 8, 30, 0, 0, ZoneId.of("Asia/Tokyo"));

    List<UTCSchedule> collected = scheduler.checkScheduleWithinDuration(localDatetime, Duration.ofHours(1));
    assertEquals(2, collected.size());
    boolean isSchedule1 = false;
    boolean isSchedule2 = false;
    boolean isSchedule3 = false;
    for (UTCSchedule s: collected) {
      if (s.getTitle().equals("Schedule 1")) {
        isSchedule1 = true; // Expected to be called
      } else if (s.getTitle().equals("Schedule 2")) {
        isSchedule2 = true;// Expected to be called
      } else if (s.getTitle().equals("Schedule 3")) {
        isSchedule3 = true;// Expected not to be called
      }
    }
    assertTrue(isSchedule1);
    assertTrue(isSchedule2);
    assertFalse(isSchedule3);
  }

}
