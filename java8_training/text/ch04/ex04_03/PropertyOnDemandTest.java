package ch04.ex04_03;

import static org.junit.Assert.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import org.junit.Before;
import org.junit.Test;

public class PropertyOnDemandTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void propertyTest() {
    PropertyOnDemand propertyOnDemand = new PropertyOnDemand();
    propertyOnDemand.setValue(5);
    assertEquals(5, propertyOnDemand.getValue());

    IntegerProperty intProperty = new SimpleIntegerProperty(3);
    intProperty.bindBidirectional(propertyOnDemand.getProperty());
    intProperty.set(10);
    assertEquals(10, propertyOnDemand.getValue());
  }

}
