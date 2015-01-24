package ch07.ex07_02;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Temp {

  public static void main(String[] args) {
    String contents = null;
    try {
      contents = new String(Files.readAllBytes(Paths.get("text/ch07/ex07_02/alice.txt")), StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.err.println("Read text file failed...");
      e.printStackTrace();
    }
    String[] words = contents.split("[\\P{L}]+");

    Stream<String> stream = Stream.of(words);
    // System.out.println(stream.count());
    stream.filter((s) -> s.length() >= 12).collect(Collectors.toSet()).stream().sorted().forEach(System.out::println);
  }

}
