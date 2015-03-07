package ch08.ex08_16;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressMatcherTest {

  @Test
  public void addressMatcherTest() {
    Address address = new Address();

    assertFalse(AddressMatcher.extractAddress("panda", address));

    assertTrue(AddressMatcher.extractAddress("Seattle, WA, 12345", address));
    assertEquals(address.city, "Seattle");
    assertEquals(address.state, "WA");
    assertEquals(address.zipcode, "12345");

    assertTrue(AddressMatcher.extractAddress("Boulder, CO, 123456789", address));
    assertEquals(address.city, "Boulder");
    assertEquals(address.state, "CO");
    assertEquals(address.zipcode, "123456789");
  }

}
