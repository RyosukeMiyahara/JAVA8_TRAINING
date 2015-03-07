package ch08.ex08_07;

import java.util.Objects;

public class Person {
  public Person(String firstName, String middleName, String lastName) {
    this.firstName = Objects.requireNonNull(firstName);
    this.middleName = middleName;
    this.lastName = Objects.requireNonNull(lastName);
  }
  private String firstName;
  private String lastName;
  private String middleName;
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getMiddleName() {
    return middleName;
  }
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }
}
