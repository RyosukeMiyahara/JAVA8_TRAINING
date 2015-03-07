package ch08.ex08_10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SearchHaves {
  public static void main(String[] args) {
    try (Stream<Path> entries = Files.walk(Paths.get("D:\\70_temoporary\\java8_src_zip"))) {
      entries.forEach(p -> {
        if (p.toFile().isFile()) {
          try {
            String contents = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
            if ((contents.indexOf("transient") != -1) && (contents.indexOf("volatile") != -1)) {
              System.out.println(p);
            }
          } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Couldn't read " + p);
          }
        }
      });
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.err.println("Couldn't run walk");
      return;
    }
  }
}
