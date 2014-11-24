package ch03.ex03_21;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class FutureMapTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void futureMapTest() {
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future<String> future = es.submit(() -> "Panda");
    Future<String> result = FutureMap.map(future, (string)->"Cute " + string);
    try {
      assertEquals("Cute Panda", result.get());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
