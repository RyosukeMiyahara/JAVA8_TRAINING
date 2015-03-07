package ch08.ex08_14;

import java.util.Objects;

public class RequireNoNullUsage {

  public static void requireNoNullUsage(Object o) {
    Object obj = Objects.requireNonNull(o, () ->
      "requireNoNull checks provided parameter is null or not. "
      + "If provided parameter is null, lambda expression, provided as second parameter is run. "
      + "When this message is shown, provided parameter is null..."
    );
    System.out.println(obj.toString());
  }

  public static void main(String[] args) {
    requireNoNullUsage(null);
  }

}
