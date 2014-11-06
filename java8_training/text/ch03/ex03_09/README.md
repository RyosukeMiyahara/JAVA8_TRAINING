# 練習問題 3-9

指定された順序で、指定されたフィールドを比較するコンパレータを生成するlexicographicComparator(String... filedNames)メソッドを書きなさい。
たとえば、lexicographicComparator("lastname", "firstname")は2つのオブジェクトを受け取り、リフレクションを使用して、lastnameフィールドの値を取得します。2つのオブジェクトのlastnameフィールドが異なれば、その差を返します。同じであれば、firstnameフィールドに移ります。すべてのフィールドが同じであれば、0を返します。