package ch02.ex02_06;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.stream.Stream;

import org.junit.Test;

public class CharacterStreamTest {

  @Test
  public void characterStreamTest() {
    Stream<Character> stream = CharacterStream.characterStream("boat");
    LinkedList<Character> list = new LinkedList<Character>();
    stream.forEach(chara->list.add(chara));
    if (!list.get(0).toString().equals("b")) {
      fail("index 0 should be b");
    }
    if (!list.get(1).toString().equals("o")) {
      fail("index 1 should be o");
    }
    if (!list.get(2).toString().equals("a")) {
      fail("index 2 should be a");
    }
    if (!list.get(3).toString().equals("t")) {
      fail("index 3 should be t");
    }
  }

  @Test
  public void characterStreamStreamVerTest() {
    Stream<Character> stream = CharacterStream.characterStreamStreamVer("boat");
    LinkedList<Character> list = new LinkedList<Character>();
    stream.forEach(chara->list.add(chara));
    if (!list.get(0).toString().equals("b")) {
      fail("index 0 should be b");
    }
    if (!list.get(1).toString().equals("o")) {
      fail("index 1 should be o");
    }
    if (!list.get(2).toString().equals("a")) {
      fail("index 2 should be a");
    }
    if (!list.get(3).toString().equals("t")) {
      fail("index 3 should be t");
    }
  }

}
