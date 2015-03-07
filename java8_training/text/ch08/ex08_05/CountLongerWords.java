package ch08.ex08_05;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountLongerWords {

  public static long countLongerWordsStream(List<String> words) {
    return words.stream().filter(w -> w.length() > 12).count();
  }

  public static long countLongerWordsNoStream(List<String> words) {
    List<String> filtered = new ArrayList<String>();
    words.forEach(w -> {
      if (w.length() > 12) {
        filtered.add(w);
      }
    });
    return filtered.size();
  }

  public static List<String> splitTextToWords(Path path) {
    String contents = null;
    try {
      contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.err.println("Read text file failed...");
      e.printStackTrace();
    }
    return Arrays.asList(contents.split("[\\P{L}]+"));
  }

  public static void main(String[] args) {
    long start;
    long end;

    List<String> words = splitTextToWords(Paths.get("text/ch06/ex06_01/alice.txt"));

    System.out.println("Stream case:");
    start = System.nanoTime();
    System.out.println("Count result: " + countLongerWordsStream(words));
    end = System.nanoTime();
    System.out.println("Time: " + (end - start) + " ns");

    System.out.println("No stream case:");
    start = System.nanoTime();
    System.out.println("Count result: " + countLongerWordsNoStream(words));
    end = System.nanoTime();
    System.out.println("Time: " + (end - start) + " ns");

  }

}
