# 練習問題2-3

streamではなく、parallelStreamで長い単語を数えた場合の速度の違いを計りなさい。呼び出しの前後でSystem.nanoTimeを呼び出して、差を表示しなさい。速いコンピュータをもっているのであれば、（『戦争と平和』（War and Peace）などの）もっと大きなドキュメントで試しなさい。

## 出力結果

	        Stream version result: 20000
	        Stream version time: 42672685nsec

	ParallelStream version result: 20000
	ParallelStream version time: 197621722nsec
