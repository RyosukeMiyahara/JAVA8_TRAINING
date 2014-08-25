# 練習問題1-11

void f()メソッドを持つ、IとJの2つのインタフェースがあり、両方を実装しているクラスがあるとします。Iインタフェースのfメソッドが抽象、デフォルト、staticのどれがであり、Jインタフェースのfメソッドが抽象、デフォルト、staticのどれかである場合、すべての組み合わせで何が起きるでしょうか。同じように、スーパークラスSを拡張し、Iインタフェースを実装した場合に、スーパークラスもインタフェースもvoid f()メソッドを持っていたら、どうなるかを調べなさい。

## 結果

|     I    |     J    |   実装するクラス   |             結果             |
|----------|----------|--------------------|------------------------------|
|   抽象   |   抽象   |   オーバーライド   |実装するクラスの実装が呼ばれる|
|   抽象   |   抽象   |オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem: 型 EX01_11 は継承された抽象メソッド J.f() を実装する必要があります|
|デフォルト|   抽象   |   オーバーライド   |実装するクラスの実装が呼ばれる|
|デフォルト|   抽象   |オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem: |
|  static  |   抽象   |   オーバーライド   |実装するクラスの実装が呼ばれる|
|  static  |   抽象   |オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem:  EX01_11 は継承された抽象メソッド J.f() を実装する必要があります|
|   抽象   |デフォルト|   オーバーライド   |実装するクラスの実装が呼ばれる|
|   抽象   |デフォルト|オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem: |
|デフォルト|デフォルト|   オーバーライド   |実装するクラスの実装が呼ばれる|
|デフォルト|デフォルト|オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem: |
|  static  |デフォルト|   オーバーライド   |実装するクラスの実装が呼ばれる|
|  static  |デフォルト|オーバーライドしない|       Jの実装が呼ばれる      |
|   抽象   |  static  |   オーバーライド   |実装するクラスの実装が呼ばれる|
|   抽象   |  static  |オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem:  EX01_11 は継承された抽象メソッド I.f() を実装する必要があります|
|デフォルト|  static  |オーバーライドしない|       Iの実装が呼ばれる      |
|デフォルト|  static  |   オーバーライド   |実装するクラスの実装が呼ばれる|
|  static  |  static  |オーバーライドしない|Exception in thread "main" java.lang.Error: Unresolved compilation problem: メソッド f() は型 EX01_11 で未定義です|
|  static  |  static  |   オーバーライド?  |実装するクラスの実装が呼ばれる|


|     I    |       結果      |
|----------|-----------------|
|   抽象   |Sの実装が呼ばれる|
|デフォルト|Sの実装が呼ばれる|
|  static  |Sの実装が呼ばれる|