# 練習問題 7-6

一連のシェルコマンドを受け取り、1つのコマンドの出力を次のコマンドの入力として接続し、最後の出力を返すJavaScriptのpipe関数を書きなさい。たとえば、pipe('find.', 'grep -v class', 'sort')と呼び出せます。単純に$EXECを繰り返し呼び出しなさい。

## 実行結果
    ryosuke-MacBookAir:ex07_06 ryosuke$ ls
    README.md		   	    panda.class
    lesserPanda.class		    pipe.js
    ryosuke-MacBookAir:ex07_06 ryosuke$ jjs -scripting pipe.js
    .
    ./README.md
    ./pipe.js

