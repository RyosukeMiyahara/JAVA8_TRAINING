package ch02.ex02_02;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class Get5LongerWordsTest {

  @Test
  public void get5LongerWordsTest() {
    // Prepare String list to create String stream
    List<String> wordList = new LinkedList<String>();
    for (int i = 0; i < 10; i++) {
      wordList.add("Panda");        // 5 characters
      wordList.add("Giant panda");  // 11 characters
      wordList.add("Lesser panda"); // 12 characters
    }

    // get 5 longer words using filter method, and show result
    Stream<String> filteredStream = Get5LongerWords.get5LongerWords(wordList.stream(), 10);
    assertEquals(filteredStream.count(), 5);
  }

}
