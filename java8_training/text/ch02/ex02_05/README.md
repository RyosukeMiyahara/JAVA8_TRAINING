# 練習問題2-5

Stream.iterateを使用して、Math.ramdomを呼び出すのではなく、線形合同生成器(linear congruential generator)を直接実装して、乱数の無限ストリームを作成しなさい。そのような生成器では、$x0=seed$で始めて、$a$, $c$, $m$の適切な値に対して、$x_n+1=(ax_n+c)%m$を生成します。パラメータ$a$, $c$, $m$, $seed$を受け取り、Stream<Long>を生成するメソッドを実装しなさい。$a=25214903917$, $c=11$, $m=2^48$を試してみなさい。
