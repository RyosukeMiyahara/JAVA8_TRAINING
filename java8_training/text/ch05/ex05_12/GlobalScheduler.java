package ch05.ex05_12;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalScheduler {
  private List<UTCSchedule> scheduleList;

  /**
   * Constructor for Global Scheduler
   * This creates shceduleList
   */
  public GlobalScheduler() {
    scheduleList = new LinkedList<UTCSchedule>();
  }

  /**
   * Add Schedule as UTCSchedule
   * Date time is converted to UTC's one
   * @param datetime to be stored as UTC
   * @param title to be stored
   */
  public void addSchedule(ZonedDateTime datetime, String title) {
    UTCSchedule schedule = new UTCSchedule(datetime.withZoneSameInstant(ZoneId.of("UTC")), title);
    scheduleList.add(schedule);
  }

  /**
   * Check Schedule within provided duration from provided datetime
   * @param datetime Schedule is checked from this
   * @param duration Schedule is checked for this duration from provided datatime
   * @return List which includes matched shcedule
   */
  public List<UTCSchedule> checkScheduleWithinDuration(ZonedDateTime datetime, Duration duration) {
    ZonedDateTime origin = datetime.withZoneSameInstant(ZoneId.of("UTC"));
    ZonedDateTime future = origin.plus(duration);
    return scheduleList.stream().filter((s) -> {
      if ( (s.getDatetime().isAfter(origin)) && (s.getDatetime().isBefore(future))) {
        return true;
      } else {
        return false;
      }
    }).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    GlobalScheduler scheduler = new GlobalScheduler();
    ZonedDateTime teleconferenceDatetime = ZonedDateTime.of(2014, 12, 15, 17, 0, 0, 0, ZoneId.of("MST7MDT"));
    scheduler.addSchedule(teleconferenceDatetime, "Tereconference with Boulder");

    ZonedDateTime localDatetime = ZonedDateTime.of(2014, 12, 16, 8, 30, 0, 0, ZoneId.systemDefault());

    List<UTCSchedule> collected = scheduler.checkScheduleWithinDuration(localDatetime, Duration.ofHours(1));
    System.out.println("Schedules within 1 hour at " + localDatetime.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")));
    for (UTCSchedule s: collected) {
      ZonedDateTime localizedDatetime = s.getDatetime().withZoneSameInstant(ZoneId.systemDefault());
      System.out.println(s.getTitle() + " on " + localizedDatetime.format(DateTimeFormatter.ofPattern("MM/dd HH:mm z")));
    }
  }
}
