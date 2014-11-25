# 練習問題 3-19

Stream<T>のメソッドである<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)を見てみなさい。BiFunctionへの最初の型引数でUを? super Uと宣言すべきですか。その理由は、何ですか。

## 回答

動作させることはできると思う。しかし、すべき理由は見当たらない