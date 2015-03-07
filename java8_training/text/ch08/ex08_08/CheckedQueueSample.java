package ch08.ex08_08;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class CheckedQueueSample {
  @SuppressWarnings("rawtypes")
  public static void getMoreWork(Queue q) {
    Path path = (Path) q.poll();
    System.out.println(path.toFile().toString());
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    // Normal Queue Case
    /*
    @SuppressWarnings("rawtypes")
    Queue q = new LinkedList();

    q.add(Paths.get("text/ch08/ex08_08/README.md"));
    q.add(Paths.get("text/ch08/ex08_08/README.md"));
    q.add("Panda");

    getMoreWork(q);
    getMoreWork(q);
    getMoreWork(q);
    */

    // CheckedQueue Case
    @SuppressWarnings("rawtypes")
    Queue q = new CheckedQueue(new LinkedList(), Path.class);

    q.add(Paths.get("text/ch08/ex08_08/README.md"));
    q.add(Paths.get("text/ch08/ex08_08/README.md"));
    q.add("Panda");

    getMoreWork(q);
    getMoreWork(q);
    getMoreWork(q);

  }

}
