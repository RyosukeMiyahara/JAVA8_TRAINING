package ch08.ex08_13;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(TestCases.class)
@Retention(RetentionPolicy.SOURCE)
@interface TestCase {
  int params();
  int expected();
}
