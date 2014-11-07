package ch03.ex03_09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class LexicoGraphicComparator {
  /**
   *
   * @param fieldNames
   * @return
   * @exception NoSuchfieldException If
   */
  public static Comparator lexicographicComparator(String... fieldNames) {
    Comparator comparator;
    comparator = (first, second) -> {
      for (int i = 0; i < fieldNames.length; i++) {
        // Get field
        Class c = first.getClass();
        Field f = null;
        try {
          f = c.getField(fieldNames[i]);
        } catch (NoSuchFieldException nse) {
          nse.printStackTrace();
        }  catch (SecurityException se) {
          se.printStackTrace();
        }

        // Compare fields
        try {
          if (f.get(first).equals(f.get(second)) || !(Comparable.class.isInstance(f.get(first)))) {
            continue;
          }
          return ((Comparable)f.get(first)).compareTo((Comparable)f.get(second));
        } catch(IllegalAccessException iae) {
          iae.printStackTrace();
        }
        continue;
      }
      return 0;
    };
  }
}
