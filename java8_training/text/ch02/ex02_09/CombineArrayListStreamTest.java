package ch02.ex02_09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Test;

public class CombineArrayListStreamTest {
  public static Stream<ArrayList<String>> createStringArrayListStream() {
    ArrayList<String> arrayList1 = new ArrayList<String>();
    ArrayList<String> arrayList2 = new ArrayList<String>();
    ArrayList<String> arrayList3 = new ArrayList<String>();
    arrayList1.add("Panda");
    arrayList1.add("Giant Panda");
    arrayList2.add("Cat");
    arrayList2.add("Dog");
    arrayList2.add("Bird");
    arrayList3.add("Mouse");
    arrayList3.add("Keyboard");
    return Stream.of(arrayList1, arrayList2, arrayList3);
  }

  public static ArrayList<String> createCombinedArrayListManually() {
    ArrayList<String> list = new ArrayList<String>();
    list.add("Panda");
    list.add("Giant Panda");
    list.add("Cat");
    list.add("Dog");
    list.add("Bird");
    list.add("Mouse");
    list.add("Keyboard");
    return list;
  }

  @Test
  public void combineArrayListStream1Test() {
    ArrayList<String> combined1 = CombineArrayListStream.combineArrayListStream1(createStringArrayListStream());
    assertArrayEquals(createCombinedArrayListManually().toArray(), combined1.toArray());
  }

  @Test
  public void combineArrayListStream2Test() {
    ArrayList<String> combined1 = CombineArrayListStream.combineArrayListStream2(createStringArrayListStream());
    assertArrayEquals(createCombinedArrayListManually().toArray(), combined1.toArray());
  }

  @Test
  public void combineArrayListStream3Test() {
    ArrayList<String> combined1 = CombineArrayListStream.combineArrayListStream3(createStringArrayListStream());
    assertArrayEquals(createCombinedArrayListManually().toArray(), combined1.toArray());
  }

}
