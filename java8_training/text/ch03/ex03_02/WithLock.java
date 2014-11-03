package ch03.ex03_02;

import java.util.concurrent.locks.ReentrantLock;

public class WithLock {

  /**
   * action is performed after myLock is locked.
   * After action is performed, myLock is unlocked.
   * @param myLock ReentrantLock for action performing
   * @param action This action is performed under myLock is locked.
   */
  public static void withLock(ReentrantLock myLock, Runnable action) {
    myLock.lock();
    try {
      action.run();
    } finally {
      myLock.unlock();
    }
  }

  public static void main(String[] args) {
    ReentrantLock myLock = new ReentrantLock();
    System.out.println(myLock.getHoldCount());
    withLock(myLock, ()->System.out.println(myLock.getHoldCount()));
    System.out.println(myLock.getHoldCount());
  }
}
