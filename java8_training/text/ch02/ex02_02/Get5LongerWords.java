package ch02.ex02_02;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Get5LongerWords {
  static final int LIMIT = 5;

  static Stream<String> get5LongerWords(Stream<String> stream, int length) {
    return stream.filter(
        word-> {
          System.out.println("filter is called");
          if (word.length() > length) {
            System.out.println("Longer word is found");
            return true;
          } else {
            return false;
          }
        }
        ).limit(LIMIT);
  }

  public static void main(String[] args) {
    // Prepare String list to create String stream
    List<String> wordList = new LinkedList<String>();
    for (int i = 0; i < 10; i++) {
      wordList.add("Panda");        // 5 characters
      wordList.add("Giant panda");  // 11 characters
      wordList.add("Lesser panda"); // 12 characters
    }

    // get 5 longer words using filter method, and show result
    Stream<String> filteredStream = get5LongerWords(wordList.stream(), 10);
    filteredStream.forEach(System.out::println);
  }
}
