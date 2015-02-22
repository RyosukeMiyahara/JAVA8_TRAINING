package ch08.ex08_01;

public class ComputeBigValues {

  public static void main(String[] args) {
    int bigValue = Integer.MAX_VALUE;
    System.out.println("Original value: " + bigValue);
    System.out.println("");
    System.out.println("Addition: ");
    System.out.println(bigValue + 1);
    System.out.println(Integer.toUnsignedLong(bigValue + 1));
    System.out.println("");
    System.out.println("Subtraction: ");
    System.out.println(bigValue + 500 - 200);
    System.out.println(Integer.toUnsignedLong(bigValue + 500 - 200));
    System.out.println("");
    System.out.println("Multiplication: ");
    System.out.println(bigValue * 2);
    System.out.println(Integer.toUnsignedLong(bigValue * 2));
    System.out.println("");
    System.out.println("Division: ");
    System.out.println(bigValue * 2 / 2);
    System.out.println(Integer.toUnsignedLong(bigValue * 2 / 2));
    System.out.println(Integer.divideUnsigned(bigValue * 2, 2));
    System.out.println("");
    System.out.println("Remind: ");
    System.out.println((bigValue * 2 + 1) % 2);
    System.out.println(Integer.toUnsignedLong((bigValue * 2 + 1) % 2));
    System.out.println(Integer.remainderUnsigned(bigValue * 2 + 1, 2));
    System.out.println("");
    System.out.println("Comparing: ");
    System.out.println((bigValue - 200) < (bigValue + 200));
    System.out.println(Integer.compareUnsigned(bigValue - 200, bigValue + 200));


  }

}
