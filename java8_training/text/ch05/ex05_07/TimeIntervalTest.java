package ch05.ex05_07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class TimeIntervalTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void startAndEndNull() {
    try {
      new TimeInterval(null, null);
      fail("NullPointerException is expected");
    } catch(Exception e) {
      assertThat(e, instanceOf(NullPointerException.class));
    }
  }

  @Test
  public void startIsNull() {
    try {
      new TimeInterval(null, LocalDateTime.now());
      fail("NullPointerException is expected");
    } catch(Exception e) {
      assertThat(e, instanceOf(NullPointerException.class));
    }
  }

  @Test
  public void endIsNull() {
    try {
      new TimeInterval(LocalDateTime.now(), null);
      fail("NullPointerException is expected");
    } catch(Exception e) {
      assertThat(e, instanceOf(NullPointerException.class));
    }
  }

  @Test
  public void overlapCase1() {
    TimeInterval timeInt1 = new TimeInterval(LocalDateTime.of(2014, 7, 1, 10, 0, 0), LocalDateTime.of(2014, 10, 1, 10, 0, 0));
    TimeInterval timeInt2 = new TimeInterval(LocalDateTime.of(2014, 4, 1, 10, 0, 0), LocalDateTime.of(2014, 8, 1, 10, 0, 0));
    assertTrue(timeInt1.isOverlappedWith(timeInt2));
  }

  @Test
  public void overlapCase2() {
    TimeInterval timeInt1 = new TimeInterval(LocalDateTime.of(2014, 7, 1, 10, 0, 0), LocalDateTime.of(2014, 10, 1, 10, 0, 0));
    TimeInterval timeInt2 = new TimeInterval(LocalDateTime.of(2014, 4, 1, 10, 0, 0), LocalDateTime.of(2014, 12, 1, 10, 0, 0));
    assertTrue(timeInt1.isOverlappedWith(timeInt2));
  }

  @Test
  public void overlapCase3() {
    TimeInterval timeInt1 = new TimeInterval(LocalDateTime.of(2014, 7, 1, 10, 0, 0), LocalDateTime.of(2014, 10, 1, 10, 0, 0));
    TimeInterval timeInt2 = new TimeInterval(LocalDateTime.of(2014, 8, 1, 10, 0, 0), LocalDateTime.of(2014, 9, 1, 10, 0, 0));
    assertTrue(timeInt1.isOverlappedWith(timeInt2));
  }

  @Test
  public void overlapCase4() {
    TimeInterval timeInt1 = new TimeInterval(LocalDateTime.of(2014, 7, 1, 10, 0, 0), LocalDateTime.of(2014, 10, 1, 10, 0, 0));
    TimeInterval timeInt2 = new TimeInterval(LocalDateTime.of(2014, 8, 1, 10, 0, 0), LocalDateTime.of(2014, 12, 1, 10, 0, 0));
    assertTrue(timeInt1.isOverlappedWith(timeInt2));
  }

  @Test
  public void notOverlapCase1() {
    TimeInterval timeInt1 = new TimeInterval(LocalDateTime.of(2014, 7, 1, 10, 0, 0), LocalDateTime.of(2014, 10, 1, 10, 0, 0));
    TimeInterval timeInt2 = new TimeInterval(LocalDateTime.of(2014, 4, 1, 10, 0, 0), LocalDateTime.of(2014, 5, 1, 10, 0, 0));
    assertFalse(timeInt1.isOverlappedWith(timeInt2));
  }

  @Test
  public void notOverlapCase2() {
    TimeInterval timeInt1 = new TimeInterval(LocalDateTime.of(2014, 7, 1, 10, 0, 0), LocalDateTime.of(2014, 10, 1, 10, 0, 0));
    TimeInterval timeInt2 = new TimeInterval(LocalDateTime.of(2014, 11, 1, 10, 0, 0), LocalDateTime.of(2014, 12, 1, 10, 0, 0));
    assertFalse(timeInt1.isOverlappedWith(timeInt2));
  }

}
