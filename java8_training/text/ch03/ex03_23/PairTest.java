package ch03.ex03_23;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PairTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void pairMapTest() {
    Pair<String> pandas = new Pair<String>("Panda", "Giant panda");
    Pair<String> cutePandas = Pair.map(pandas, (string) -> "Cute " + string);
    assertEquals("Cute Panda", cutePandas.getFirst());
    assertEquals("Cute Giant panda", cutePandas.getSecond());
  }

}
