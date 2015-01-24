# 練習問題 7-2

jjsを実行し、ストリームライブラリを使用して、次の問題に対する解放をインタラクティブに求めなさい。問題：あるファイルに含まれている長い単語（12文字より長い）を重複なしですべてソートして表示しなさい。最初に単語を読み込んで、長い単語を選択してという具合に行いなさい。このインタラクティブな取り組み方は、通常のワークフローと比較してどうですか。

## 実行結果

    jjs> var bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get('alice.txt'));
    jjs> var content = new java.lang.String(bytes);
    jjs> var words = java.util.Arrays.asList(content.split(/\W/));
    jjs> var dist = new java.util.TreeSet(words)
    jjs> var stream = dist.stream()
    jjs> var filtered = stream.filter(function(s) s.length() >= 12)
    jjs> var sorted = filtered.sorted()
    jjs> sorted.forEach(function(s) print(s.toString()))
    CONSEQUENTIAL
    Contributions
    International
    MERCHANTIBILITY
    Multiplication
    Redistributing
    Redistribution
    Uglification
    accidentally
    affectionately
    circumstances
    confirmation
    considerable
    consultation
    contemptuous
    contemptuously
    contradicted
    contributions
    conversation
    conversations
    difficulties
    disappointment
    distributing
    distribution
    electronically
    explanations
    extraordinary
    frontispiece
    hippopotamus
    identification
    infringement
    inquisitively
    intellectual
    interrupting
    modification
    neighbouring
    nevertheless
    nonproprietary
    occasionally
    opportunities
    particularly
    performances
    redistribute
    redistributing
    redistribution
    refreshments
    representations
    requirements
    restrictions
    solicitation
    straightened
    straightening
    thoughtfully
    thunderstorm
    transcription
    triumphantly
    uncomfortable
    uncomfortably
    unenforceability
    null
    jjs>

> このインタラクティブな取り組み方は、通常のワークフローと比較してどうですか。

簡単なチェックを行いたい、という観点では良いと思うが、jjsとJavaの違いがかなりあったため、その点に苦労した。
