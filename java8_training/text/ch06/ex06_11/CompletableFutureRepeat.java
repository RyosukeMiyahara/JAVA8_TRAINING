package ch06.ex06_11;

import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CompletableFutureRepeat {
  // private PasswordAuthentication passwordAuthentication;
  public static Scanner in1 = new Scanner(System.in);

  /**
   * Repeat to run action until "until" returns true
   * @param action function to be run repeatedly
   * @param until action is run until this function returns true
   * @return Recursive CompletableFuture with action and until
   */
  public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
    return CompletableFuture.supplyAsync(action).thenComposeAsync((T t) -> {
      return until.test(t) ? CompletableFuture.completedFuture(t) : repeat(action, until);
    });
  }

  /**
   * Get PasswordAuthentication from console input
   * @return PasswordAuthentication with username and password provided by user
   */
  public static PasswordAuthentication getPasswordAuthentication() {
    System.out.print("Username: ");
    String user = in1.nextLine();
    System.out.print("Password: ");
    String pass = in1.nextLine();
    return new PasswordAuthentication(user , pass.toCharArray());
  }

  public static void main(String[] args) {
    System.out.println("Inputting...");
    repeat(CompletableFutureRepeat::getPasswordAuthentication, (pa) -> {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return Arrays.equals(pa.getPassword(), "secret".toCharArray());
    });
    ForkJoinPool.commonPool().awaitQuiescence(20,  TimeUnit.SECONDS);
    System.out.println("Exitting.");
  }
}
