package ch09.ex09_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReverseLines {

  public static void main(String[] args) {
    try {
      List<String> lines = Files.readAllLines(Paths.get("text/ch09/ex09_06/animals.txt"));
      Collections.reverse(lines);
      Files.write(Paths.get("text/ch09/ex09_06/slamina.txt"), lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
