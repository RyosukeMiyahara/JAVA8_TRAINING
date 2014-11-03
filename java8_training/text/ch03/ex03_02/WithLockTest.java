package ch03.ex03_02;

import static org.junit.Assert.*;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class WithLockTest {

  @Test
  public void withLockTest() {
    ReentrantLock myLock = new ReentrantLock();
    assertEquals(0, myLock.getHoldCount());
    WithLock.withLock(myLock, ()->assertEquals(1, myLock.getHoldCount()));
    assertEquals(0, myLock.getHoldCount());
  }

}
