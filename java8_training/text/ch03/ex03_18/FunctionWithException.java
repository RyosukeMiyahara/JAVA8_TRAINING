package ch03.ex03_18;


public interface FunctionWithException<T, U> {
  U apply(T t) throws Exception;
}
