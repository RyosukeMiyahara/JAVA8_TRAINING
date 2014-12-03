package ch03.sandbox;

import java.util.function.Function;

public class FunctionTest {
  public static void functionTest(Function<Employee, Person> f) {

  }
  public static void main(String[] args) {
    // Person person = new Person();
    // Employee employee = new Employee();
    // functionTest((Person person)->{return new Employee();});
    functionTest((Employee employee)->{return new Person();});
    functionTest((Employee employee)->{return new Employee();});
  }

}
