package ch02.ex02_06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EX02_06 {

  public static Stream<Character> characterStream(String s) {
    List<Character> result = new ArrayList<>();
    for (char c : s.toCharArray())
      result.add(c);
    return result.stream();
  }

  public static Stream<Character> characterStreamStreamVer(String s) {
    Stream<Character> result = Stream.iterate(0, n->n+1).limit(s.length()).map(s::charAt);

    return result;
  }

  public static void main(String[] args) {
    Stream<Character> stream1 = characterStream("boat");
    stream1.forEach(chara->System.out.println(chara));
    System.out.println("");

    Stream<Character> stream2 = characterStreamStreamVer("boat");
    stream2.forEach(chara->System.out.println(chara));
    System.out.println("");
  }

}
