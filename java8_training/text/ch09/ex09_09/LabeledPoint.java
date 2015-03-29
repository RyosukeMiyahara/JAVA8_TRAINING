package ch09.ex09_09;

import java.util.Objects;

public class LabeledPoint {
  private String label;
  private int x;
  private int y;
  public LabeledPoint(String label, int x, int y) {
    this.label = label;
    this.x = x;
    this.y = y;
  }
  public String getLabel() {
    return label;
  }
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public boolean equals(Object otherObject) {
    LabeledPoint other = (LabeledPoint) otherObject;
    return Objects.equals(label, other.getLabel()) && Objects.equals(x, other.getX()) && Objects.equals(y, other.getY());
  }
  public int hashCode() {
    return Objects.hash(label, x, y);
  }
}
