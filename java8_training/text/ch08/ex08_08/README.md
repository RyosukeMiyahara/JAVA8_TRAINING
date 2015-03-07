# 練習問題 8-8

CheckedQueueクラスの利点を示すプログラムを書きなさい。

## 実行結果

### Normal Queue Case

    text\ch08\ex08_08\README.md
    text\ch08\ex08_08\README.mdException in thread "main"
    java.lang.ClassCastException: java.lang.String cannot be cast to java.nio.file.Path
    	at ch08.ex08_08.CheckedQueueSample.getMoreWork(CheckedQueueSample.java:11)
    	at ch08.ex08_08.CheckedQueueSample.main(CheckedQueueSample.java:26)


### CheckedQueue Case

    Exception in thread "main" java.lang.ClassCastException: Cannot cast java.lang.String to java.nio.file.Path
    	at java.lang.Class.cast(Class.java:3258)
    	at ch08.ex08_08.CheckedQueue.add(CheckedQueue.java:78)
    	at ch08.ex08_08.CheckedQueueSample.main(CheckedQueueSample.java:38)