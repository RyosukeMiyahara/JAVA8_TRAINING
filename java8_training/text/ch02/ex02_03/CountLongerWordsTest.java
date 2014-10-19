package ch02.ex02_03;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class CountLongerWordsTest {
  private LinkedList<String> words;

  @Before
  public void setUp() throws Exception {
    words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }
  }

  @Test
  public void countLongerWordsStreamTest() {
    assertEquals(CountLongerWords.countLongerWordsStream(words), 20000);
  }

  @Test
  public void countLongerWordsParallelStream() {
    assertEquals(CountLongerWords.countLongerWordsParallelStream(words), 20000);
  }

}