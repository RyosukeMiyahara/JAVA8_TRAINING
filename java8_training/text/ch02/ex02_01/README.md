# 練習問題2-1
24ページの2.1節「イテレーションからストリーム操作へ」のforループの並列バージョンを書きなさい。リストのセグメントごとに処理を行う別々のスレッドを多数生成し、処理が終わるごとに結果を合計するようにしなさい（みなさんは、単一カウンターを更新するためにスレッドを使用したくはないでしょう。なぜですか）。