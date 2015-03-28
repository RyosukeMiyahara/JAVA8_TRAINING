# 練習問題 9-1

212ページの9.1.1節「try-with-resources文」の最後にある ScannerとPrinterを生成しているコードを、try-with-resouces文を使用しないで実装しなさい。両方のオブジェクトが適切に生成された場合には、両方のオブジェクトをきちんとクローズしなさい。次の事柄を考慮すること。

* Scannerのコンストラクタは、例外をスローする。
* PrinterWriterのコンストラクタは、例外をスローする。
* hasNext、next、printlnのメソッドは、例外をスローする。
* in.close()は、例外をスローする。
* out.close()は、例外をスローする。
