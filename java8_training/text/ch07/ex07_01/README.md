# 練習問題 7-1

たとえば、ZonedDateTimeクラスなど、試してみたいJava APIを選びなさい。そのうえで、オブジェクトの生成、メソッドの呼び出し、戻り値の表示など、jjsを使った実験を行いなさい。また、Javaでテストプログラムを書くよりは簡単かどうかを検証しなさい。

## 実験結果

    jjs> var str = new java.lang.StringBuilder('Panda')
    jjs> str.toString()
    Panda
    jjs> str.append(' is very cute')
    Panda is very cute
    jjs> str.length()
    18
    jjs> str.toString()
    Panda is very cute
    jjs>

> Javaでテストプログラムを書くよりは簡単かどうかを検証しなさい。

実行してすぐ結果が得られたり、型を指定しなくても良かったり、ちょっと試す分には簡単だと思うが、ある程度複雑なことを試したかったら、Javaでコードを書いたほうが結果的には早いと思う。