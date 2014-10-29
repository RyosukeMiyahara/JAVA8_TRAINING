package ch03.ex03_01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeferredLogger {
  static private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  static private int assessingCount = 0;

  public static void setLoggerLevel(Level newLevel) {
    logger.setLevel(newLevel);
  }

  public static void info(Logger logger, Supplier<String> message) {
    if(logger.isLoggable(Level.INFO)) {
      logger.info(message.get());
    }
  }

  public static <T> void logInfo(Level level, BooleanSupplier filter, Supplier<String> message) {
    if (logger.isLoggable(level)) {
      assessingCount++;
      if (filter.getAsBoolean()) {
        logger.log(level, message.get());
      }
    }
  }


  public static int getAssessingCount() {
    return assessingCount;
  }
}
