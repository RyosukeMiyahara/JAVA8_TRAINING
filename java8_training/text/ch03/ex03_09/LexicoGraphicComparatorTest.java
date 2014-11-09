package ch03.ex03_09;

import java.util.Arrays;

import org.junit.Test;

public class LexicoGraphicComparatorTest {

  public class Person {
    public String firstname;
    public String lastname;
    public String nickname;
  }

  @SuppressWarnings("unchecked")
  @Test
  public void test() {
    Person person1 = new Person();
    person1.firstname = "11111";
    person1.lastname = "55555";
    person1.nickname = "person1";

    Person person2 = new Person();
    person2.firstname = "55555";
    person2.lastname = "11111";
    person2.nickname = "person2";

    Person[] persons = {person1, person2};

    Arrays.sort(persons, LexicoGraphicComparator.lexicographicComparator("firstname", "lastname"));

    for(int i = 0; i < persons.length; i++) {
      System.out.println(persons[i].nickname);
    }

    Arrays.sort(persons, LexicoGraphicComparator.lexicographicComparator("lastname", "firstname"));

    for(int i = 0; i < persons.length; i++) {
      System.out.println(persons[i].nickname);
    }
  }

}
