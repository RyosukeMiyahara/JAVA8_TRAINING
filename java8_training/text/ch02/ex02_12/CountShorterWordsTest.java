package ch02.ex02_12;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.junit.Test;

public class CountShorterWordsTest {

  @Test
  public void countShorterWordsAtomicTest() {
  Stream<String> parallelWords = Stream.of("1", "22", "22", "333", "333", "333", "4444", "4444", "4444", "4444");
  AtomicInteger[] arrayAtomicInteger = CountShorterWords.countShorterWordsAtomic(4, parallelWords);

  AtomicInteger[] expected = {new AtomicInteger(0), new AtomicInteger(1), new AtomicInteger(2), new AtomicInteger(3)};

  for(int i = 0; i < expected.length; i++) {
    if (expected[i].get() != arrayAtomicInteger[i].get()) {
      fail("Index " + i + " does not match. Expected: " + expected[i] + " and actual: " + arrayAtomicInteger[i]);
    }
  }
  }
}