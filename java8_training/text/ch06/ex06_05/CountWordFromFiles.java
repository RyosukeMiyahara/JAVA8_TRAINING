package ch06.ex06_05;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountWordFromFiles {

  /**
   * Check used words for multiple files using multiple threads
   * If a word is used, record it and its file
   * @param files used words are checked in these files
   * @return map of used word and its file
   */
  static public ConcurrentHashMap<String, Set<File>> countWordFromFiles(File[] files) {
    ConcurrentHashMap<String, Set<File>> result = new ConcurrentHashMap<String, Set<File>>();

    // Parse file contents
    String[] contents = new String[files.length];
    ArrayList<String[]> words = new ArrayList<String[]>();
    for (int i = 0; i < files.length; i++) {
      try {
        contents[i] = new String(Files.readAllBytes(Paths.get(files[i].getAbsolutePath())), StandardCharsets.UTF_8);
      } catch (Exception e) {
        System.err.println("Read text file failed...");
        e.printStackTrace();
      }
      words.add(contents[i].split("[\\P{L}]+"));
    }

    ExecutorService pool = Executors.newCachedThreadPool();
    for (int i = 0; i < words.size(); i++) {
      int offset = i;
      pool.submit(() -> {
        for (String word : words.get(offset)) {
          TreeSet<File> temp = new TreeSet<File>();
          temp.add(files[offset]);
          result.merge(word, temp, (left, right) -> {
            left.addAll(right);
            left.add(files[offset]);
            return left;
          });
        }
      });
    }

    pool.shutdown();
    try {
      pool.awaitTermination(10, TimeUnit.SECONDS);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
