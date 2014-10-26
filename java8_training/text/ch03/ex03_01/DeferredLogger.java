package ch03.ex03_01;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class DeferredLogger {
  static private Logger instanceLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  public static void info(Logger logger, Supplier<String> message) {
    if(logger.isLoggable(Level.INFO)) {
      logger.info(message.get());
    }
  }

  public static <T> void logInfo(Level level, Predicate<T> filter, Supplier<String> message) {
    if (instanceLogger.isLoggable(level)) {
      if (filter.test(null)) {

      }
    }
  }
  public static void main(String[] args) {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    logger.addHandler(new StreamHandler(){
      {
        setOutputStream(System.out);
        setLevel(Level.ALL);
      }
    });
    logger.setUseParentHandlers(false);
    logger.setLevel(Level.ALL);

    logger.fine("Loggerテスト3です。fine");
    logger.info("Loggerテスト3です。info");
    logger.severe("Loggerテスト3です。severe");
  }
}
