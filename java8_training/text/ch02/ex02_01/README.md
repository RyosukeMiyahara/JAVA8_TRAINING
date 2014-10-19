# 練習問題2-1
24ページの2.1節「イテレーションからストリーム操作へ」のforループの並列バージョンを書きなさい。リストのセグメントごとに処理を行う別々のスレッドを多数生成し、処理が終わるごとに結果を合計するようにしなさい（みなさんは、単一カウンターを更新するためにスレッドを使用したくはないでしょう。なぜですか）。

## 出力結果

Sequential version result: 20000
Sequential version time: 6msec

ParallelStream version result: 20000
ParallelStream version time: 175msec

ParallelThread version result: 20000
ParallelThread version time: 153msec

## > （みなさんは、単一カウンターを更新するためにスレッドを使用したくはないでしょう。なぜですか）。
同期に注意しなければならないため。