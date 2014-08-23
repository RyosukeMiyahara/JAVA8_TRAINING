package ch01.ex01_09;

import java.util.LinkedList;


public class Main extends LinkedList<String> implements Collection2<String> {

  public static void main(String[] args) {
    Main main = new Main();
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
