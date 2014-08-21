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
    Runnable first = () -> {System.out.println("I'm first!");};
    Runnable second = () -> {System.out.println("I'm second!!");};
    Runnable combined = AndThen.andThen(first, second);
    Thread thread = new Thread(combined);
    thread.start();
  }

}
