# 練習問題 8-11

パスワード保護されたウェブページの内容を取得するプログラムを書きなさい。URLConnection connection = url.openConnection();を呼び出しなさい。文字列username:passwordを生成して、それをBase64でエンコードしなさい。それから、connection.setRequestProperty("Authorization", "Basic " + encoded string)を呼び出し、次にconnection.connect()とconnection.getInputStream()を呼び出しなさい。
