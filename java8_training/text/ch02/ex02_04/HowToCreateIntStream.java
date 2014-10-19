package ch02.ex02_04;

import java.util.stream.Stream;

public class HowToCreateIntStream {

  public static void main(String[] args) {
    int[] values = {1, 4, 9, 16};

    Stream<int[]> streamIntArray = Stream.of(values);
    streamIntArray.forEach(intArrayElement->System.out.println(intArrayElement));

    Stream<Integer> streamInteger = Stream.of(1, 4, 9, 16);
    streamInteger.forEach(integerElement->System.out.println(integerElement));

  }

}
