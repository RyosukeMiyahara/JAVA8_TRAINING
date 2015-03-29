package ch09.ex09_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CreditSearcher {

  /**
   * Search credit card number recursively
   * @param targetPath Credit card number is searched under this directory
   * @return LinkedList including found numbers
   */
  public static LinkedList<String> searchCredit(String targetPath) {
    LinkedList<String> result = new LinkedList<String>();
    try {
      ProcessBuilder builder = new ProcessBuilder("grep", "-roh", "'[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}'", targetPath);
      Process process = builder.start();
      process.waitFor();
      BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = null;
      while((line = br.readLine()) != null) {
        result.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

}
