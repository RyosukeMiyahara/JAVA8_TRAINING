package ch03.ex03_01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeferredLogger {
  static private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  static private int assessingCount = 0;

  /**
   * Set logger level
   * @param newLevel Lebel to be set
   */
  public static void setLoggerLevel(Level newLevel) {
    logger.setLevel(newLevel);
  }

  /**
   * Log message to provided logger, if provided logger accepts INFO level
   * @param logger Log message to this logger
   * @param message This message is logged
   */
  public static void info(Logger logger, Supplier<String> message) {
    if(logger.isLoggable(Level.INFO)) {
      logger.info(message.get());
    }
  }

  /**
   * Log message when provided level is accepted and condition(second argument) is true.
   * If level is not accepted, condition(second argument) is not assessed
   * @param level Only if this level is accepted, condition is assessed.
   * @param condition Only if this condition is true, message is logged.
   * @param message This message is logged.
   */
  public static <T> void logIf(Level level, BooleanSupplier condition, Supplier<String> message) {
    if (logger.isLoggable(level)) {
      assessingCount++; // For Unit test
      if (condition.getAsBoolean()) {
        logger.log(level, message.get());
      }
    }
  }

  /**
   * Getter for assessingCount.
   * @return assessing count.
   */
  public static int getAssessingCount() {
    return assessingCount;
  }
}
