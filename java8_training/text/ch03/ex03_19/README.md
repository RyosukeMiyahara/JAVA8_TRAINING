# 練習問題 3-19

Stream<T>のメソッドである<U> U reduce(U identity, BiFunction<T, ? super T, U> accumulator, BinaryOperator<U> combiner)を見てみなさい。BiFunctionへの最初の型引数でUを? usper Uと宣言すべきですか。その理由は、何ですか。
