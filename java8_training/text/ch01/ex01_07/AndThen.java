package ch01.ex01_07;

public class AndThen {

  public static Runnable andThen(Runnable first, Runnable second) {
    Runnable combined = ()->{
      first.run();
      second.run();
    };
    return combined;
  }

  public static void main(String[] args) {
    Runnable combined = AndThen.andThen(
        () -> {System.out.println("I'm first!");},
        () -> {System.out.println("I'm second!!");}
        );
    Thread thread = new Thread(combined);
    thread.start();
  }

}
