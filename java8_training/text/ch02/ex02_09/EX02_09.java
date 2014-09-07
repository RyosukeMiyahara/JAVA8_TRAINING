package ch02.ex02_09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class EX02_09 {
  public static <T> ArrayList<T> combineArrayListStream(Stream<ArrayList<T>> stream) {
    ArrayList<T> arrayList = new ArrayList<T>();
    arrayList = stream.reduce(arrayList, (first, second)->{
      first.addAll(second);
      return first;
    });
    return arrayList;
  }

  public static void main(String[] args) {
    ArrayList<String> arrayList1 = new ArrayList<String>();
    ArrayList<String> arrayList2 = new ArrayList<String>();
    ArrayList<String> arrayList3 = new ArrayList<String>();
    arrayList1.add("Panda");
    arrayList1.add("Giant Panda");
    arrayList1.add("Lesser Panda");
    arrayList2.add("Cat");
    arrayList2.add("Dog");
    arrayList2.add("Bird");
    arrayList3.add("Mouse");
    arrayList3.add("Keyboard");
    Stream<ArrayList<String>> stream = Stream.of(arrayList1, arrayList2, arrayList3);
    ArrayList<String> combined = combineArrayListStream(stream);
    for(String word: combined) {
      System.out.println(word);
    }
  }

}
