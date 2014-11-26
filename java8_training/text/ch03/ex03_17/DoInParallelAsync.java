package ch03.ex03_17;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class DoInParallelAsync {
  /**
   * Do operations parallel and asynchronously
   * @param first first operation
   * @param second second operation
   * @param handler throwable handler
   */
  public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
    Callable<Object> callable1 = Executors.callable(first);
    Callable<Object> callable2 = Executors.callable(second);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Object> future1 = executorService.submit(callable1);
    Future<Object> future2 = executorService.submit(callable2);
    try {
      future1.get();
      future2.get();
    } catch (Exception e) {
      handler.accept(e);
    }
  }

  public static void main(String[] args) {
    doInParallelAsync(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("first");
        if (i == 5) {
          int[] numbers = { 1 };
          numbers[1] = 1;
        }
        try {
          // Thread.sleep(1);
      } catch (Exception e) {

      }
    }
  }, () -> {
    for (int i = 0; i < 10; i++) {
      System.out.println("second");
    }
  }, (throwable) -> throwable.printStackTrace());
  }

}
