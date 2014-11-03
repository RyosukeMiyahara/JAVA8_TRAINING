# 練習問題3-2

ReentrantLockを使用する場合には、次のイデオムでロックとアンロックをする必要があります。

    myLock.lock();
    try {
      何らかの処理
    } finally {
      myLock.unlock();
    }
    
次のように呼び出すことができるwithLockメソッドを提供しなさい。

    withLock(myLock, () -> { 何らかの処理 })
