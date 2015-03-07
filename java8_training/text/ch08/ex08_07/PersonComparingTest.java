package ch08.ex08_07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class PersonComparingTest {

  @Test
  public void test() {
    Person pandaaaa = new Person("Panda", "aaa", "Giant");
    Person pandaNull = new Person("Panda", null, "Giant");
    Person pandazzz = new Person("Panda", "zzz", "Giant");

    Person[] pandaArray = {pandazzz, pandaNull, pandaaaa};
    Person[] expected = {pandazzz, pandaNull, pandaaaa};

    Arrays.sort(pandaArray, Comparator.comparing(Person::getMiddleName, Comparator.nullsLast(Comparator.reverseOrder())));
    Arrays.sort(expected,   Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder())).reversed());

    assertArrayEquals(expected, pandaArray);
  }

}
