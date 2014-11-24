package ch03.ex03_17;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoInParallelAsyncTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void doInParallelAsyncNormalTest() {
    int[] first = { 0 };
    int[] second = { 0 };
    DoInParallelAsync.doInParallelAsync(() -> {
      for (int i = 0; i < 10; i++) {
        first[0]++;
      }
    }, () -> {
      for (int i = 0; i < 10; i++) {
        second[0]++;
      }
    }, (throwable) -> throwable.printStackTrace());
    try{Thread.sleep(500);}catch(Exception e){}
    assertEquals(10, first[0]);
    assertEquals(10, second[0]);
  }

  @Test
  public void doInParallelAsyncFirstExceptionTest() {
    int[] first = { 0 };
    int[] second = { 0 };
    DoInParallelAsync.doInParallelAsync(() -> {
      for (int i = 0; i < 10; i++) {
        first[1]++;
      }
    }, () -> {
      for (int i = 0; i < 10; i++) {
        second[0]++;
      }
    }, (throwable) -> {
      System.out.println("hoge");
      first[0] = 500;
      throwable.printStackTrace();
    });
    try{Thread.sleep(500);}catch(Exception e){}
    assertEquals(500, first[0]);
    assertEquals(10, second[0]);
  }

  @Test
  public void doInParallelAsyncSecondExceptionTest() {
    int[] first = { 0 };
    int[] second = { 0 };
    DoInParallelAsync.doInParallelAsync(() -> {
      for (int i = 0; i < 10; i++) {
        first[0]++;
      }
    }, () -> {
      for (int i = 0; i < 10; i++) {
        second[1]++;
      }
    }, (throwable) -> {
      second[0] = 500;
      throwable.printStackTrace();
    });
    try{Thread.sleep(500);}catch(Exception e){}
    assertEquals(10, first[0]);
    assertEquals(500, second[0]);
  }

}
