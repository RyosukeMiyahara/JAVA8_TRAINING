package ch08.ex08_13;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@interface TestCases {
  TestCase[] value();
}

