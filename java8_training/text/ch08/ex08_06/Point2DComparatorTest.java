package ch08.ex08_06;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class Point2DComparatorTest {

  @Test
  public void point2DComparatorTest() {
    Point2D oneOne = new Point2D.Double(1, 1);
    Point2D oneTwo = new Point2D.Double(1, 2);
    Point2D twoOne = new Point2D.Double(2, 1);

    Point2D[] point2DArray = {twoOne, oneTwo, oneOne};
    Point2D[] expected = {oneOne, oneTwo, twoOne};

    Arrays.sort(point2DArray, Comparator.comparingDouble(Point2D::getX).thenComparingDouble(Point2D::getY));

    assertArrayEquals(expected, point2DArray);
  }

}
