# 練習問題 3-10

なぜ、次の呼び出しができないのでしょうか。

    UnaryOperator op = Color::brighter;
    Image finalImage = transform(image, op.compose(Color::grayscale));

UnaryOperator<T>のcomposeメソッドの戻り値型を注意深く調べなさい。なぜ、transformメソッドに対しては、適切ではないのでしょうか。関数合成に関しては、ストラクチャル型(structural type)とノミナル型(nominal type)のユーティリティに関して、何が言えますか。

## 回答

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
      Objects.requireNonNull(before);
      return (V v) -> apply(before.apply(v));
    }

    コンパイルエラー：
	- 型の不一致: Function<Color,Color> から UnaryOperator<Color>
	 には変換できません
	- 型 Sample のメソッド transform(Image, UnaryOperator<Color>)
	 は引数 (Image, Function<Color,Color>) に適用できません
	- トークン ")" に構文エラーがあります。このトークンを削除してください


型が一致していないため、上記の呼び出しができない。

ストラクチャル型であれば同じ型と見なされるかもしれないが、Javaはノミナル型であるため、上記の呼び出しができない。
