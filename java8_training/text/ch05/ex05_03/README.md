# 練習問題 5-3

Predicate<LocalDate>を受け取り、TemporalAdjusterを返すnextメソッドを実装しなさい。返されたTemporalAdjusterは、nextメソッドに渡された述語を満足する翌日の日付を生成します。たとえば、次のコードを見てください。

    today.with(next(w -> getDayOfWeek().getValue() < 6))

このコードは、今日より後にあって平日となる最初の日付を返します。
