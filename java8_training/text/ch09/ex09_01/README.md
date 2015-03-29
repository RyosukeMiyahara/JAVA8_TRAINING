# 練習問題 9-1

212ページの9.1.1節「try-with-resources文」の最後にある ScannerとPrinterを生成しているコードを、try-with-resouces文を使用しないで実装しなさい。両方のオブジェクトが適切に生成された場合には、両方のオブジェクトをきちんとクローズしなさい。次の事柄を考慮すること。

* Scannerのコンストラクタは、例外をスローする。
* PrinterWriterのコンストラクタは、例外をスローする。
* hasNext、next、printlnのメソッドは、例外をスローする。
* in.close()は、例外をスローする。
* out.close()は、例外をスローする。

## 実行結果

inputPath, outputPath共に生成できた場合

    in is closed.
    out is closed.

inputPathは生成できたがoutputPath生成時に例外がスローされた場合

    java.io.FileNotFoundException: text\ch09\ex09_01\README.md (プロセスはファイルにアクセスできません。別のプロセスが使用中です。)
    	at java.io.FileOutputStream.open(Native Method)
    	at java.io.FileOutputStream.<init>(FileOutputStream.java:206)
    	at java.io.FileOutputStream.<init>(FileOutputStream.java:95)
    	at java.io.PrintWriter.<init>(PrintWriter.java:184)
    	at ch09.ex09_01.ReplaceTryWithResource.replaceTryWithResources(ReplaceTryWithResource.java:15)
    	at ch09.ex09_01.ReplaceTryWithResource.main(ReplaceTryWithResource.java:42)
    in is closed.
