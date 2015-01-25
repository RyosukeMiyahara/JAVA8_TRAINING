# 練習問題 7-9

ユーザーの年齢を取得して、年齢に1を加えて、Next year, you will be ...と表示するnextYear.jsスクリプトを書きなさい。年齢は、コマンドラインで指定するか、環境変数AGEで指定することができます。どちらも指定されていなければ、ユーザーに問い合わせるようにしなさい。

## 実行結果

    ryosuke-MacBookAir:ex07_09 ryosuke$ jjs -scripting nextYear.js -- 10
    Next year, you will be 11 years old.
    ryosuke-MacBookAir:ex07_09 ryosuke$ export AGE=20
    ryosuke-MacBookAir:ex07_09 ryosuke$ jjs -scripting nextYear.js
    Next year, you will be 21 years old.
    ryosuke-MacBookAir:ex07_09 ryosuke$ unset AGE
    ryosuke-MacBookAir:ex07_09 ryosuke$ jjs -scripting nextYear.js
    Current your age is: 30
    Next year, you will be 31 years old.
    ryosuke-MacBookAir:ex07_09 ryosuke$ 
