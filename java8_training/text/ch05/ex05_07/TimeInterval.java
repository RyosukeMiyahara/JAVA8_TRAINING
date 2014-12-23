package ch05.ex05_07;

import java.time.LocalDateTime;

public class TimeInterval {
  private LocalDateTime start;
  private LocalDateTime end;

  /**
   * Constructor for TimeInterval
   * If end is before start, they are reversed
   * @param start Interval start date
   * @param end Interval end date
   * @throws NullPointerException
   */
  public TimeInterval(LocalDateTime start, LocalDateTime end) {
    if ( (start == null) || (end == null) ) {
      throw new NullPointerException("start or end is null");
    }

    if (start.isEqual(end)) {
      // Do nothing
    }

    if (start.isBefore(end)) {
      this.start = start;
      this.end = end;
    } else {
      this.start = end;
      this.end = end;
    }
  }

  public LocalDateTime getStart() {
    return start;
  }

  public void setStart(LocalDateTime start) {
    this.start = start;
  }

  public LocalDateTime getEnd() {
    return end;
  }

  public void setEnd(LocalDateTime end) {
    this.end = end;
  }

  /**
   * Check TimeInterval overlapps the other
   * @param other Check target
   * @return true if overlapped
   */
  public boolean isOverlappedWith(TimeInterval other) {
    if (other.getStart().isBefore(this.start)) {
      if (other.getEnd().isBefore(this.start)) {
        return false;
      }
    }
    if (other.getStart().isAfter(this.end)) {
      if (other.getEnd().isAfter(this.end)) {
        return false;
      }
    }
    return true;
  }
}
