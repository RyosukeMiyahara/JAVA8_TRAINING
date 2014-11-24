package ch03.ex03_20;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListMapTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void listMapTest() {
    List<String> pandas = Arrays.asList("Panda", "Giant panda");
    List<String> cutePandas = ListMap.map(pandas, (string) -> {return "Cute " + string;});
    List<String> expected = Arrays.asList("Cute Panda", "Cute Giant panda");
    assertArrayEquals(expected.toArray(), cutePandas.toArray());
  }

}
