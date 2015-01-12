package ch06.ex06_07;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class SearchMaximumFromCHMTest {

  @Test
  public void test() {
    ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();

    map.put("snake", -5L);
    map.put("rabbit", 20L);
    map.put("panda", 10000L);
    map.put("cat", 5L);
    map.put("dog", 3L);

    assertEquals("panda", SearchMaximumFromCHM.searchMaximumFromCHM(map));
  }

}
