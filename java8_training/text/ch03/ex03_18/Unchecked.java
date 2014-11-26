package ch03.ex03_18;

import java.util.function.Function;

public class Unchecked {
  /**
   * Create Function from Function which may throw exception
   * @param fwe Function which may throw exception
   * @return Function
   */
  public static <T, U> Function<T, U> unchecked(FunctionWithException<T, U> fwe) {
    return(t) -> {
      try {
        return fwe.apply(t);
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      } catch (Throwable th) {
        throw th;
      }
    };
  }
}
