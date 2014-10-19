package ch02.ex02_08;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class ZipStreamTest {

  @Test
  public void zipTest() {
    Stream<String> stream1 = Stream.of("1st", "2nd", "3rd", "4th", "5th", "6th");
    Stream<String> stream2 = Stream.of("Panda", "Giant panda", "Lesser panda");
    Stream<String> mixed = ZipStream.zip(stream1, stream2);

    String[] expected = {"1st", "Panda", "2nd", "Giant panda", "3rd", "Lesser panda"};
    assertArrayEquals(expected, mixed.toArray());
  }

}
