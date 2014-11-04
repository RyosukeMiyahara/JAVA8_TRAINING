# 練習問題3-5

次は、ColorTransformerの具体例です。次のように、画像の周りに枠を付加します。最初に、62ページの3.3節「関数型インタフェースの選択」のtransformメソッドを、UnaryOperator<Color>の代わりにColorTransformerで実装しなさい。それから、画像の周りの10ピクセルを灰色の枠で置き換えるために、そのtransformメソッドを適切なラムダ式で呼び出しなさい。
