# 練習問題 3-22

CompletableFutureに対するflatMap操作は存在しますか。存在するなら、それは何ですか。

## 回答
存在すると思う：

    <U> CompletableFuture<U> thenCompose(Function<? super T,? extends CompletionStage<U>> fn)

このステージが正常に完了したときに、このステージを指定された関数への引数に設定して実行される新しいCompletionStageを返します。