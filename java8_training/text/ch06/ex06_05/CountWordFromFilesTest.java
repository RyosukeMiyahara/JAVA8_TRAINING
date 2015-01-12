package ch06.ex06_05;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class CountWordFromFilesTest {

  @Test
  public void test() {
    File alice = new File("text/ch06/ex06_05/alice.txt");
    File noAlice = new File("text/ch06/ex06_05/alice_noAlice.txt");
    File[] files = {
        alice,
        noAlice
    };
    ConcurrentHashMap<String, Set<File>> result = CountWordFromFiles.countWordFromFiles(files);

    assertEquals(1, result.get("Alice").size());
    assertTrue(result.get("Alice").contains(alice));

    assertEquals(2, result.get("and").size());
    assertTrue(result.get("and").contains(alice));
    assertTrue(result.get("and").contains(noAlice));
  }

}
