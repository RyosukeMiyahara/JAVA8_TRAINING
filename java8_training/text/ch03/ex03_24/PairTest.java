package ch03.ex03_24;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class PairTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void flatMapTest() {
    Pair<String> pandas = new Pair<String>("Panda", "Giant Panda");
    Stream<Character> lowerPandas = pandas.flatMap((t) -> {
      List<Character> result = new ArrayList<Character>();
      for (char c: t.toCharArray()) {
        result.add(Character.toLowerCase(c));
      }
      return result.stream();
    });
    Character[] expected = {'p','a','n','d','a','g','i','a','n','t',' ','p','a','n','d','a'};
    assertArrayEquals(expected, lowerPandas.toArray());
  }

}
