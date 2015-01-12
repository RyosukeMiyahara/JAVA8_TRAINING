package ch06.ex06_07;

import java.util.concurrent.ConcurrentHashMap;

public class SearchMaximumFromCHM {

  /**
   * Search maximum value from ConcurrentHashMap, then, return its key
   * @param map target ConcurrentHashMap
   * @return key which has maximum value
   */
  static public String searchMaximumFromCHM(ConcurrentHashMap<String, Long> map) {
    return map.reduceEntries(1, (entry1, entry2) -> {
      if (entry1.getValue() > entry2.getValue()) {
        return entry1;
      } else {
        return entry2;
      }
    }).getKey();
  }
}
