package ch08.ex08_06;

import static org.junit.Assert.*;

import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class Rectangle2DComparatorTest {

  @Test
  public void rectangle2DComparatorTest() {
    Rectangle2D oneOneOneOne = new Rectangle2D.Double(1, 1, 1, 1);
    Rectangle2D oneOneOneTwo = new Rectangle2D.Double(1, 1, 1, 2);
    Rectangle2D twoOneOneOne = new Rectangle2D.Double(2, 1, 1, 1);
    Rectangle2D oneOneThreeOne = new Rectangle2D.Double(1, 1, 3, 1);

    Rectangle2D[] rectangle2DArray = {twoOneOneOne, oneOneThreeOne, oneOneOneOne, oneOneOneTwo};
    Rectangle2D[] expected = {oneOneOneOne, oneOneOneTwo, oneOneThreeOne, twoOneOneOne};

    Arrays.sort(rectangle2DArray, Comparator
        .comparingDouble(Rectangle2D::getX)
        .thenComparingDouble(Rectangle2D::getY)
        .thenComparingDouble(Rectangle2D::getWidth)
        .thenComparingDouble(Rectangle2D::getHeight));

    assertArrayEquals(expected, rectangle2DArray);
  }
}
