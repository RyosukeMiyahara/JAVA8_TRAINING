# 練習問題 8-3

ユークリッドのアルゴリズム（200年以上前のものです）は、2つの数値の最大公約数（greatest common divisor）を計算します。bが0であれば、gcd(a, b)=aであり、そうでなければ、gcd(b, rem(a, b))です。remは、余りを意味しています。aかbが負であったとしても、明らかにgcdは、負になるべきではありません（なぜなら、その値の符号を正にしたものの方がより大きな約数となるからです）。gcdのアルゴリズムを%、floorMode、数学的な（負ではない）余りを生成するrem関数で実装しなさい。これらの3つの方法のどれが負の値に対して最も簡単ですか。