package ch08.ex08_15;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

public class MockGrepTest {

  @Test
  public void test() {
    List<String> list = MockGrep.mockGrep(Paths.get("text/ch08/ex08_15/animals.txt"), Pattern.compile(".*panda.*"));

    String[] expected = {"panda", "giant panda", "lesser panda"};

    assertArrayEquals(expected, list.toArray());
  }

}
