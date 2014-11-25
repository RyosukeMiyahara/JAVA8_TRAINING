# 練習問題3-4

Filterという名前を持つ関数型インタフェースが、Java APIにはいくつありますか。そのうちのどれが、Predicate<T>よりも付加価値がありますか。

## 回答

### Filterという名前を持つ関数型インタフェース

    java.io.FileFilter
    java.io.FilenameFilter
    java.nio.file.DirectoryStream.Filter<T>
    java.util.logging.Filter

参考：https://docs.oracle.com/javase/jp/8/api/java/lang/class-use/FunctionalInterface.html

### そのうちのどれが、Predicate<T>よりも付加価値がありますか。

特にPredicate<T>よりも付加価値があるようには思えない。