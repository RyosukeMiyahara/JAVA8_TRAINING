package ch08.ex08_08;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

@SuppressWarnings("rawtypes")
public class CheckedQueue<T> implements Queue{
  private Queue queue;
  private Class className;

  public CheckedQueue(Queue queue, Class className) {
    this.queue = queue;
    this.className = className;
  }

  @Override
  public int size() {
return queue.size();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return queue.contains(o);
  }

  @Override
  public Iterator iterator() {
    return queue.iterator();
  }

  @Override
  public Object[] toArray() {
    return queue.toArray();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Object[] toArray(Object[] a) {
    return queue.toArray(a);
  }

  @Override
  public boolean remove(Object o) {
    return queue.remove(o);
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean containsAll(Collection c) {
    return queue.containsAll(c);
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean addAll(Collection c) {
    return queue.addAll(c);
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean removeAll(Collection c) {
    return queue.removeAll(c);
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean retainAll(Collection c) {
    return queue.retainAll(c);
  }

  @Override
  public void clear() {
    queue.clear();
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean add(Object e) {
    return queue.add(className.cast(e));
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean offer(Object e) {
    return queue.offer(e);
  }

  @Override
  public Object remove() {
    return queue.remove();
  }

  @Override
  public Object poll() {
    return queue.poll();
  }

  @Override
  public Object element() {
    return queue.element();
  }

  @Override
  public Object peek() {
    return queue.peek();
  }
}
