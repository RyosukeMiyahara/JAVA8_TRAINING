# 練習問題1-6

Runnable内でチェックされる例外を処理しなければならないことが、いつも面倒だと思っていませんか。チェックされるすべての例外をキャッチし、それをチェックされない例外へ変えるuncheckメソッドを書きなさい。例えば、次のように使用します。

    new Thread(uncheck(() ->
    { System.out.println("Zzz"); Thread.sleep(1000); })).
    start();
      // catch (InterruptedException)が必要ありません！

ヒント：どのような例外でもスローできるrunメソッドを持つRunnableExインタフェースを定義します。そして、public static Runnable uncheck(RunnableEx runner)を実装します。uncheck関数内でラムダ式を使用します。

なぜ、RunnableExの代わりにCallable<Void>を使用できないのでしょうか。
