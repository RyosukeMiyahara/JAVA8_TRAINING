package ch03.ex03_16;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoInOrderAyncTest {
  String[] strings = { "panda" };

  @Before
  public void setUp() throws Exception {
    strings[0] = "panda";
  }

  @Test
  public void doInOrderAsyncNormaltest() {
    DoInOrderAsync.doInOrderAsync(() -> {
      return "Giant Panda";
    }, (firstResult, throwable) -> {
      if (firstResult != null) {
        strings[0] = firstResult;
      } else {
        strings[0] = "Exception";
        throwable.printStackTrace();
      }
    });
    try {
      Thread.sleep(500);
    } catch (Exception e) {
    }
    assertEquals("Giant Panda", strings[0]);
  }

  @Test
  public void doInOrderAsyncExceptiontest() {
    DoInOrderAsync.doInOrderAsync(() -> {
      strings[1] = "Bad panda";
      return "Giant Panda";
    }, (firstResult, throwable) -> {
      if (firstResult != null) {
        strings[0] = firstResult;
      } else {
        strings[0] = "Exception";
        throwable.printStackTrace();
      }
    });
    try {
      Thread.sleep(500);
    } catch (Exception e) {
    }
    assertEquals("Exception", strings[0]);
  }
}
