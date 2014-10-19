package ch01.ex01_09;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Collection2Test {

  @Test
  public void collection2Test() {
    Collection2Sample collection2Sample = new Collection2Sample();
    collection2Sample.add("Panda");
    collection2Sample.add("Dog");
    collection2Sample.add("Lesser Panda");
    collection2Sample.add("Cat");
    collection2Sample.add("Giant Panda");

    LinkedList<String> filtered = new LinkedList<String>();
    collection2Sample.forEachIf(
        string->filtered.add(string),
        string->{
          if (string.indexOf("Panda") != -1) {
            return true;
          } else {
            return false;
          }
        }
        );
    assertEquals(filtered.size(), 3);
  }
}
