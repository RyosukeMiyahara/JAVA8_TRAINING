package ch02.sandbox;

import java.util.LinkedList;
import java.util.List;

public class ForEach {

  public static void main(String[] args) {
    List<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    list.stream().forEach(System.out::println);

    System.out.println("");

    list.parallelStream().forEach(System.out::println);

    System.out.println("");

    list.parallelStream().forEachOrdered(System.out::println);

    System.out.println("");
    long start = 0;
    long end = 0;

    start = System.currentTimeMillis();
    list.parallelStream().forEach((i)->{
      try{
        Thread.sleep(1000);
        System.out.println(i);
        }catch(Exception e){

        }});
    end = System.currentTimeMillis();
    System.out.println("Time: " + (end - start));

    System.out.println("");

    start = System.currentTimeMillis();
    list.parallelStream().forEachOrdered((i)->{
      try{
        Thread.sleep(1000);
        System.out.println(i);
        }catch(Exception e){

        }});
    end = System.currentTimeMillis();
    System.out.println("Time: " + (end - start));
  }

}
