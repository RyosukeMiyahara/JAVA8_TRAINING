package ch08.ex08_09;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScannerConverter {
  private Scanner scanner;

  public ScannerConverter(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * Convert lines stream from Scanner
   * @return lines stream of scanner
   */
  public Stream<String> words() {
    scanner.useDelimiter("[ ]|\r\n");
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        scanner, Spliterator.ORDERED | Spliterator.NONNULL), false);
    /*
    // lines() of BufferedReader
    Iterator<String> iter = new Iterator<String>() {
        String nextLine = null;

        @Override
        public boolean hasNext() {
            if (nextLine != null) {
                return true;
            } else {
                try {
                    nextLine = readLine();
                    return (nextLine != null);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
        }

        @Override
        public String next() {
            if (nextLine != null || hasNext()) {
                String line = nextLine;
                nextLine = null;
                return line;
            } else {
                throw new NoSuchElementException();
            }
        }
    };
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
            iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    */
  }

  /**
   * Convert lines stream from Scanner
   * @return lines stream of scanner
   */
  public Stream<String> lines() {
    scanner.useDelimiter("\\r\\n");
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        scanner, Spliterator.ORDERED | Spliterator.NONNULL), false);
  }

  /**
   * Convert Integer stream from Scanner
   * @return Integers stream of scanner
   */
  public Stream<Integer> ints() {
    Iterator<Integer> iter = new Iterator<Integer>() {
      Integer nextInt = null;

      @Override
      public boolean hasNext() {
        if (nextInt != null) {
          return true;
        } else {
          try {
            nextInt = scanner.nextInt();
          } catch (NoSuchElementException e) {
            nextInt = null;
          }
          return (nextInt != null);
        }
      }

      @Override
      public Integer next() {
        if (nextInt != null || hasNext()) {
          Integer integer = nextInt;
          nextInt = null;
          return integer;
        } else {
          throw new NoSuchElementException();
        }
      }
    };
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
  }

  /**
   * Convert Double stream from Scanner
   * @return Doubles stream of scanner
   */
  public Stream<Double> doubles() {
    Iterator<Double> iter = new Iterator<Double>() {
      Double nextDouble = null;

      @Override
      public boolean hasNext() {
        if (nextDouble != null) {
          return true;
        } else {
          try {
            nextDouble = scanner.nextDouble();
          } catch (NoSuchElementException e) {
            nextDouble = null;
          }
          return (nextDouble != null);
        }
      }

      @Override
      public Double next() {
        if (nextDouble != null || hasNext()) {
          Double dbl = nextDouble;
          nextDouble = null;
          return dbl;
        } else {
          throw new NoSuchElementException();
        }
      }
    };
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
        iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
  }


}
