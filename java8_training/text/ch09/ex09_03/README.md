# 練習問題 9-3

複数例外をキャッチするcatch節でキャッチした例外をサイドスローする場合に、その処理が書かれているメソッドのthrows宣言には、例外の型をどのように宣言しますか。たとえば、次の例を考えなさい。

    public void process() throws ... {
      try {
        ...
      } catch (FileNotFoundException | UnknownHostException ex) {
        logger.log(Level.SEVERE, "...", ex);
        throw ex;
      }
    }
