package ch09.ex09_03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultipleExceptionSample {
  public void process(int num, Logger logger) throws IOException {
    try {
      if (num == 0) {
        throw new FileNotFoundException();
      } else {
        throw new UnknownHostException();
      }
    } catch (FileNotFoundException | UnknownHostException ex) {
      logger.log(Level.SEVERE, "...", ex);
      throw ex;
    }
  }
}
