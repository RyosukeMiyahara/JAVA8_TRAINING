package ch09.ex09_08;

public class Point {
  int x;
  int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int compareTo(Point other) {
    if ( x > other.x) {
      return 1;
    } else if (x < other.x) {
      return -1;
    } else if (y > other.y) {
      return 1;
    } else if (y < other.y) {
      return -1;
    }
    return 0;
  }
}
