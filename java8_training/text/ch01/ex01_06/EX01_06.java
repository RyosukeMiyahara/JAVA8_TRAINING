package ch01.ex01_06;

public class EX01_06 {

  public static Runnable uncheck(RunnableEx runner) {
    return () -> {try {
      runner.run();
    } catch(Exception ex) {
      System.out.println(ex);
    }
  };
  }

  public static void main(String[] args) {
    new Thread(uncheck(() ->
    {
      System.out.println("Zzz");
      Thread.sleep(1000);
    })).start();
    // catch(InteruptedException)が必要ありません！
  }

}
