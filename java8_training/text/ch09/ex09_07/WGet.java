package ch09.ex09_07;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WGet {

  public static void main(String[] args) {
    try {
      URL url = new URL("http://horstmann.com");
      InputStream in = url.openStream();
      Files.copy(in, Paths.get("text/ch09/ex09_07/horstmann.html"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
