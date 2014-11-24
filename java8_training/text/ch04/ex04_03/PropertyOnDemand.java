package ch04.ex04_03;

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
  public int getValue() {
    if (property == null) {
      return normalInt;
    } else {
      return property.get();
    }
  }

  /**
   * Set integer value
   * If property is not created, create it and set new value to property
   * @param newValue to be set to property
   */
  public void setValue(int newValue) {
    if (property == null) {
      property = new SimpleIntegerProperty(normalInt);
      property.set(newValue);
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
