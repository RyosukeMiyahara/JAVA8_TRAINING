package ch03.ex03_01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeferredLogger {
  static private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  public static void setLoggerLevel(Level newLevel) {
    logger.setLevel(newLevel);
  }

  public static void info(Logger logger, Supplier<String> message) {
    if(logger.isLoggable(Level.INFO)) {
      logger.info(message.get());
    }
  }

  public static <T> void logInfo(Level level, BooleanSupplier filter, Supplier<String> message) {
    System.out.println("a");
    if (logger.isLoggable(level)) {
      System.out.println("hoge");
      if (filter.getAsBoolean()) {
        System.out.println("fuga");
        logger.log(level, message.get());
      }
    }
  }

  public static void main(String[] args) {
    String a[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    DeferredLogger.setLoggerLevel(Level.FINEST);
    int i = 10;
    logInfo(Level.INFO, () -> i == 10, () -> "A[10] = " + a[10]);
    int j = 5;
    logInfo(Level.FINEST, () -> j == 10, () -> "A[10] = " + a[10]);
  }
}
