package ch05.ex05_03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class TemporalAdjusterImpl {

  /**
   * Return TemporalAdjuster which achieves provided filter
   * @param filter Return TemporalAdjuster which achives this filter
   * @return TemporalAdjuster which achives this filter
   */
  public static TemporalAdjuster next(Predicate<LocalDate> filter) {
    TemporalAdjuster result = LocalDate.now();
    while(true) {
      result = ((LocalDate)result).plusDays(1);
      if (filter.test((LocalDate)result)) {
        return result;
      }
    }
  }
}
