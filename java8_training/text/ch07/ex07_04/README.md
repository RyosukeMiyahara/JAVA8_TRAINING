# 練習問題 7-4

文字列から部分文字列を抽出することでリテラルでないJavaScript文字列を生成し、getClassメソッドを呼び出しなさい。結果はどのクラスになりますか。それから、そのクラスをjava.lang.String.class.castへ渡しなさい。何が起きますか。それが起きた理由は何ですか。

    jjs> var subs = 'Hello'.slice(-2)
    jjs> subs
    lo
    jjs> subs.getClass()
    class java.lang.String
    jjs> java.lang.String.class.cast(subs)
    lo
    jjs> java.lang.String.class.cast(subs).getClass()
    class java.lang.String


java.lang.Stringクラスになった。java.lang.String.class.castへ渡しても、クラスは変わらないため、何も起こらなかった。