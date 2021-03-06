package ch06.ex06_10;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {

  public static Scanner in1 = new Scanner(System.in);
  private static Scanner in2;

  public static String getPage(String urlString)  {
    try {
       in2 = new Scanner(new URL(urlString).openStream());
       StringBuilder builder = new StringBuilder();
       while (in2.hasNextLine()) {
          builder.append(in2.nextLine());
          builder.append("\n");
       }
       return builder.toString();
    } catch (IOException ex) {
       RuntimeException rex = new RuntimeException();
       rex.initCause(ex);
       throw rex;
    }
 }

 public static List<String> matches(String input, String patternString) {
    Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(input);
    List<String> result = new ArrayList<>();

    while (matcher.find())
       result.add(matcher.group(1));
    return result;
 }

 public static String getInput(String prompt) {
    System.out.print(prompt + ": ");
    return in1.nextLine();
 }

 public static void main(String[] args) throws ExecutionException, InterruptedException {
   String hrefPattern = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
   CompletableFuture<String> getURL = CompletableFuture.supplyAsync(() -> ExtractLinks.getInput("URL"));
   CompletableFuture<String> readPage = getURL.thenApply((String url) -> ExtractLinks.getPage(url));
   CompletableFuture<List<String>> getLinks = readPage.thenApply(c -> ExtractLinks.matches(c, hrefPattern));
   getLinks.thenAccept(System.out::println);
   ForkJoinPool.commonPool().awaitQuiescence(20,  TimeUnit.SECONDS);
   System.out.println("exiting");
}

}
