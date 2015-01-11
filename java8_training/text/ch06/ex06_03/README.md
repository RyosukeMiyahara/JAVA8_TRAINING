# 練習問題6-3

1,000個のスレッドを生成し、各スレッドは、ある1つのカウンターを100,000回だけ1ずつ増加させます。AtomicLongとLongAdderを使用した場合の性能を比較しなさい。

## 実行結果

AtomicLong version time: 2825642458nsec
 LongAdder version time: 621041274nsec
