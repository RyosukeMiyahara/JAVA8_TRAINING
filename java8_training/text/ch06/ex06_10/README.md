# 練習問題 6-10

ユーザーにURLを問い合わせて、そのURLのウェブページを読み込み、すべてのリンクを表示するプログラムを作成しなさい。各ステップに対して、CompletableFutureを使用しなさい。getを呼び出さないこと。プログラムの処理が終わる前に終了しないようにするために、次の呼び出しを行いなさい。

    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);

## 実行結果

 URL: http://panda.holy.jp/programming-recipe/
["static/about.html", "hello_world/c/index.html", "comment/c/index.html", "get_absolute_value/c/index.html", "show_current_local_time/c/index.html", "hello_world/cpp/index.html", "replace_string/cpp/index.html", "get_absolute_value/cpp/index.html", "hello_world/java/index.html", "hello_world/php/index.html", "comment/php/index.html", "get_absolute_value/php/index.html", "show_current_local_time/php/index.html", "hello_world/go/index.html", "get_absolute_value/go/index.html", "show_current_local_time/go/index.html", "hello_world/ruby/index.html", "get_absolute_value/ruby/index.html", "http://www.apache.org/licenses/LICENSE-2.0"]
exiting
