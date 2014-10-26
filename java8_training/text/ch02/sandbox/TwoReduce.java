package ch02.sandbox;

import java.util.LinkedList;
import java.util.List;

public class TwoReduce {

  public static void main(String[] args) {
    List<String> words = new LinkedList<String>();
    words.add("a");
    words.add("bb");
    words.add("ccc");
    // int result = words.reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
    // int result = words.reduce(0, (total, word) -> total + word.length());
    // int result = words.parallelStream().reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
    int result = words.stream().reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 * total2);
    System.out.println(result);
  }

}
