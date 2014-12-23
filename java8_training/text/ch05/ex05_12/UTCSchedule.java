package ch05.ex05_12;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UTCSchedule {
  private ZonedDateTime datetimeUTC;
  private String title;

  public ZonedDateTime getDatetime() {
    return datetimeUTC;
  }

  /**
   * Set Date time as UTC
   * @param datetime to be stored as UTC
   */
  public void setDatetime(ZonedDateTime datetime) {
    this.datetimeUTC = datetime.withZoneSameInstant(ZoneId.of("UTC"));
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Constructor for UTCSchedule
   * Date time is stored as UTC
   * @param datetime to be stored as UTC
   * @param title to be stored
   */
  public UTCSchedule(ZonedDateTime datetime, String title) {
    this.datetimeUTC = datetime.withZoneSameInstant(ZoneId.of("UTC"));
    this.title = title;
  }
}
