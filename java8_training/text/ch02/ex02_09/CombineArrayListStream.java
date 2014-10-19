package ch02.ex02_09;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class CombineArrayListStream {

  /**
   * Combine array list stream using simple reduce
   * @param stream This stream is combined
   * @return Combined array list
   */
  public static <T> ArrayList<T> combineArrayListStream1(Stream<ArrayList<T>> stream) {
    Optional<ArrayList<T>> result = stream.reduce((first, second)->{
      first.addAll(second);
      return first;
    });
    if (result.isPresent()) {
      return result.get();
    } else {
      return null;
    }
  }

  /**
   * Combine array list stream using reduce with identity
   * @param stream This stream is combined
   * @return Combined array list
   */
  public static <T> ArrayList<T> combineArrayListStream2(Stream<ArrayList<T>> stream) {
    ArrayList<T> arrayList = new ArrayList<T>();
    arrayList = stream.reduce(arrayList, (first, second)->{
      first.addAll(second);
      return first;
    });
    return arrayList;
  }

  /**
   * Combine array list stream using reduce with identity and combiner
   * @param stream This stream is combined
   * @return Combined array list
   */
  public static <T> ArrayList<T> combineArrayListStream3(Stream<ArrayList<T>> stream) {
    ArrayList<T> arrayList = new ArrayList<T>();
    arrayList = stream.reduce(arrayList,
        (result, list) -> {result.addAll(list); return result;},
        (result1, result2) -> {result1.addAll(result2); return result1;});
    return arrayList;
  }

  public static Stream<ArrayList<String>> createStringArrayListStream() {
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
    return Stream.of(arrayList1, arrayList2, arrayList3);
  }

  public static void main(String[] args) {
    System.out.println("combineArrayListStream1");
    ArrayList<String> combined1 = combineArrayListStream1(createStringArrayListStream());
    for(String word: combined1) {
      System.out.println(word);
    }

    System.out.println("combineArrayListStream2");
    ArrayList<String> combined2 = combineArrayListStream2(createStringArrayListStream());
    for(String word: combined2) {
      System.out.println(word);
    }

    System.out.println("combineArrayListStream3");
    ArrayList<String> combined3 = combineArrayListStream3(createStringArrayListStream());
    for(String word: combined3) {
      System.out.println(word);
    }

  }

}
