# 練習問題 7-3

jjsを実行しなさい。そして、次の呼び出しを行いなさい。

    var b = new java.math..BigInteger('1234567890987654321')

それから、bを表示しなさい（単にbと入力してEnterを押します）。何が得られましたか。b.mod(java.math.BigInteger.TEN)の値は何ですか。bはなぜ、奇妙に表示されるのですか。bの実際の値をどうやって表示できますか。

## 実行結果

    jjs> var b = new java.math.BigInteger('1234567890987654321')
    jjs> b
    1234567890987654400
    jjs> b.mod(java.math.BigInteger.TEN)
    1


単にbと入力すると、1234567890987654321がjavascriptに変換されるが、扱える範囲を超えるため、表示がおかしくなる
http://so-zou.jp/web-app/tech/programming/javascript/grammar/data-type/number/

mod()の場合は、Javaとして先に演算を行い、扱える範囲の数字をjavascriptで表示しようとするため、問題は生じない。

bの実際の値をどうやって表示できますか。

    jjs> java.lang.String.format('%d', b)
    1234567890987654321

