package ch08.ex08_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MockGrep {

  /**
   * Mock grep implemented by Java8
   * @param path grep target
   * @param pattern grep condition
   * @return String list which includes grep result
   */
  public static List<String> mockGrep(Path path, Pattern pattern) {
    LinkedList<String> result = new LinkedList<String>();
    try {
      Stream<String> stream = Files.lines(path);
      stream.filter(pattern.asPredicate()).forEach(w -> result.add(w));
      stream.close();
      return result;
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return result;
    }

  }
}
