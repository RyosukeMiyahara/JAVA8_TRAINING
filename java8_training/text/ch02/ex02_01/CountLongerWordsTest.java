package ch02.ex02_01;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class CountLongerWordsTest {

  @Test
  public void countLongerWordsSequentialTest() {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }
    assertEquals(CountLongerWords.countLongerWordsSequential(words), 20000);
  }

  @Test
  public void countLongerWordsParallelStreamTest() {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }
    assertEquals(CountLongerWords.countLongerWordsParallelStream(words), 20000);
  }

  @Test
  public void countLongerWordsParallelThreadTest() {
    LinkedList<String> words = new LinkedList<String>();
    for (int i = 0; i < 10000; i++) {
      words.add("Panda");
      words.add("Lesser Panda");
      words.add("Giant Panda");
    }
    CountLongerWords countLongerWords = new CountLongerWords();
    assertEquals(countLongerWords.countLongerWordsParallelThread(words), 20000);
  }

}