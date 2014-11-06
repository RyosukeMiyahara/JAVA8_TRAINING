# 練習問題 3-10

なぜ、次の呼び出しができないのでしょうか。

    UnaryOperator op = Color::brighter;
    Image finalImage = transform(image, op.compose(Color::grayscale));

UnaryOperator<T>のcomposeメソッドの戻り値型を注意深く調べなさい。なぜ、transformメソッドに対しては、適切ではないのでしょうか。関数合成に関しては、ストラクチャル型(structural type)とノミナル型(nominal type)のユーティリティに関して、何が言えますか。
