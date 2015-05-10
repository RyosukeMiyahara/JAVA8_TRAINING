# 練習問題 8-12

TestCaseアノテーションを定義し、そのアノテーションを持つクラスをロードして、アノテーションが付けられたメソッドを呼び出し、メソッドが期待した値を生成するかを検査するプログラムを実装しなさい。パラメータと戻り値は整数だと想定しなさい。

## 実行結果

    D:\10_development\git\java8_training\JAVA8_TRAINING\java8_training\text>javac ch08\ex08_12\*.java

    D:\10_development\git\java8_training\JAVA8_TRAINING\java8_training\text>javac -processor ch08.ex08_12.TestCaseProcessor ch08\ex08_12\Factorial.java
    OK
    OK
    NG, expected = 1, but actual = 24 from param: 4