# 練習問題 4-5

次のメソッドを書きなさい。

    public static <T, R> ObservableValue<R> observe(
      Function<T, R> f, ObservableValue<T> t)
    public static <T, U, R> ObservableValue<R> observe (
      BiFunction<T, U, R> f, ObservableValue<T> t,
      ObservableValue<U> u)

このメソッドは、ObservableValueを返し、そのObservableValueのgetValueメソッドはラムダ式の値を返します。そして、そのObservableValueのInvalidationListenerとChangeListenerが、入力のどれかが無効あるいは変更になったときに呼び出されるようにしなさい。たとえば、次の通りです。

    larger.disablePropert().bind(observe(
    t -> t >= 100, gauge.widthProperty()));

