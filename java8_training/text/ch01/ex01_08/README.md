# 練習問題1-8

ラムダ式が次のような拡張forループ内の値をキャプチャした場合には、どうなりますか。

    String[][ names = { "Peter", "Paul", "Mary" };
    List<Runnable> runners = new ArrayList<>();
    for(String name: names)
    runners.add(() -> System.out.println(name));

これは、正当なコードでしょうか。各ラムダ式は異なる値をキャプチャするのでしょうか。それとも、すべてのラムダ式が最後の値をキャプチャするのでしょうか。従来のfor(int i = 0; i < names.length; i++)ループを使用すると、どうなるでしょうか。
