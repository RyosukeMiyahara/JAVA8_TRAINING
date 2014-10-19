package ch01.ex01_09;

import java.util.LinkedList;


public class Collection2Sample extends LinkedList<String> implements Collection2<String> {

  public static void main(String[] args) {
    Collection2Sample main = new Collection2Sample();
    main.add("Panda");
    main.add("Dog");
    main.add("Lesser Panda");
    main.add("Cat");
    main.add("Giant Panda");
    main.forEachIf(
        string->System.out.println("*" + string + "*"),
        string->{
          if (string.indexOf("Panda") != -1) {
            return true;
          } else {
            return false;
          }
        }
        );
  }
}
