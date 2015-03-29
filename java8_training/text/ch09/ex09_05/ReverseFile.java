package ch09.ex09_05;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseFile {

  public static void main(String[] args) {
    try {
      byte[] bytes = Files.readAllBytes(Paths.get("text/ch09/ex09_05/panda.txt"));
      byte[] rBytes = new byte[bytes.length];
      for (int i = 0; i < bytes.length; i++) {
        rBytes[i] = bytes[bytes.length - 1 - i];
      }
      Files.write(Paths.get("text/ch09/ex09_05/adnap.txt"), rBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
