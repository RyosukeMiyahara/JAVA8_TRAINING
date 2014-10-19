package ch02.ex02_11;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamToArrayListTest {

  @Test
  public void streamToArrayListTest() {
    ArrayList<String> wordList = StreamToArrayList.streamToArrayList(Stream.of("panda", "Giant panda", "Lesser panda"), 3);
    assertEquals(3, wordList.size());
    assertTrue(wordList.contains("panda"));
    assertTrue(wordList.contains("Giant panda"));
    assertTrue(wordList.contains("Lesser panda"));
  }

}
