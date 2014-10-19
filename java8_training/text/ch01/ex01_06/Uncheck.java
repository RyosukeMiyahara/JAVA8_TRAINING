package ch01.ex01_06;

import java.util.concurrent.Callable;

public class Uncheck {

  public static Runnable uncheck(RunnableEx runner) {
    return () -> {
      try {
      runner.run();
      } catch(Exception ex) {
        System.out.println(ex);
      }
    };
  }

  public static Runnable uncheckCallable(Callable<?> runner) {
    return () -> {
      try {
      runner.call();
      } catch(Exception ex) {
        System.out.println(ex);
      }
    };
  }

  public static void main(String[] args) {
    new Thread(uncheck(() -> {
      System.out.println("Zzz on uncheck");
      Thread.sleep(1000);
    })).start();
    // catch(InteruptedException)が必要ありません！

    new Thread(uncheckCallable(() -> {
        System.out.println("Zzz on uncheckCallable");
        Thread.sleep(1000);
        return null;
      }
    )).start();
    // catch(InteruptedException)が必要ありません！
  }

}
