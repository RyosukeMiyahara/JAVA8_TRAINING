# 練習問題 6-10

ユーザーにURLを問い合わせて、そのURLのウェブページを読み込み、すべてのリンクを表示するプログラムを作成しなさい。各ステップに対して、CompletableFutureを使用しなさい。getを呼び出さないこと。プログラムの処理が終わる前に終了しないようにするために、次の呼び出しを行いなさい。

    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
 