# 練習問題1-1

Arrays.sortメソッド内で呼び出されるコンパレータのコードは、sortメソッドを呼び出したスレッドで実行されるでしょうか。それとも、別のスレッドで実行されるでしょうか。

## 出力結果

    Main thread name: main

    0: Lesser panda
    1: Panda
    2: Giant panda

    Thread name of comparator; main
    Thread name of comparator; main
    Thread name of comparator; main
    Thread name of comparator; main
    Sorted!

    0: Panda
    1: Giant panda
    2: Lesser panda

## 回答
sortメソッドを呼び出してスレッドで実行された