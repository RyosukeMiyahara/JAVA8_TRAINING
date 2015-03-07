# 練習問題 8-5

第2章の初めで、リスト内の長い単語をwords.stream().filter(x -> w.length() > 12).count()で数えました。ラムダ式を用いて、ストリームを使用しないで、同じことを行いなさい。長いリストに対してはどちらの操作が速いですか。

## 実行結果

    Stream case:
    Count result: 33
    Time: 80515249 ns
    No stream case:
    Count result: 33
    Time: 6183185 ns
