package ch08.ex08_16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressMatcher {
  /**
   * Extract string which has U.S.A. address format
   * @param line to be checked
   * @return provided line is U.S.A. address, returns true. If no, returns false.
   */
  public static boolean extractAddress(String line, Address address) {
    Pattern pattern = Pattern.compile("(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2}),\\s*(?<zipcode>[0-9]{5}|[0-9]{9})");
    Matcher m = pattern.matcher(line);
    if (m.matches()) {
      address.city = m.group("city");
      address.state = m.group("state");
      address.zipcode = m.group("zipcode");
      return true;
    }
    return false;
  }

}
