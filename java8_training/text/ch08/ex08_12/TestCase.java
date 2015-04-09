package ch08.ex08_12;

import java.lang.annotation.Repeatable;

@Repeatable(TestCases.class)
@interface TestCase {
  int params();
  long expected();
}

@interface TestCases {
  TestCase[] value();
}

