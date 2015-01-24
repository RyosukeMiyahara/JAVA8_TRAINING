# 練習問題 7-5

172ページの7.10節「Javaクラスの拡張とJavaインタフェースの実装」の終わりでは、addに対するすべての呼び出しをログに記録するようにArrayListを拡張する方法を説明しました。しかし、それは、単一オブジェクトに対してのみ機能します。ログを記録するArrayListを何個でも生成できるようにするために、そのような複数オブジェクトを生成するファクトリとなるJavaScript関数を書きなさい。

## 実行結果

    $ jjs loggedArrayFactory.js
    Adding panda1
    Adding panda2
    Adding panda3
    Adding panda4
