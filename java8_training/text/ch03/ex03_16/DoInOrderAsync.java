package ch03.ex03_16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DoInOrderAsync {
  /**
   * Do specified operations asynchronously
   * @param first first operation
   * @param second second operation with throwable handler
   */
  public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
    Thread t = new Thread() {
      public void run() {
            T result = null;
          try {
            result = first.get();
            second.accept(result, null);
          } catch(Throwable throwable) {
            second.accept(null, throwable);
          }
      }
    };
    t.start();
  }

}
