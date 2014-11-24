package ch04.ex04_02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyOnDemand {
  private int normalInt = 0;
  private IntegerProperty property = null;

  /**
   * Return integer value
   * @return if property is created, return propert.get()
   *         if not, return normal int value
   */
  public final int getValue() {
    if (property == null) {
      return normalInt;
    } else {
      return property.get();
    }
  }

  /**
   * Set integer value
   * @param newValue if property is created, set new value to property
   *                 if not, set it to normal int
   */
  public final void setValue(int newValue) {
    if (property == null) {
      normalInt = newValue;
    } else {
      property.set(newValue);
    }
  }

  /**
   * Return property. If not created yet, create and return it
   * @return IntegerProperty
   */
  public IntegerProperty getProperty() {
    if (property == null) {
      property = new SimpleIntegerProperty(normalInt);
      return property;
    } else {
      return property;
    }
  }
}
