package com.example.mybmi


//BMI計算結果をプロパティとして持つデータ型にする
data class BmiInfo(val bmi: Int ) {
    //結果表示。BmiInfoのみで使用の為入れ子
    enum class Type (var bodyType: String){
        Low("痩せ型"),
        Middle("標準"),
        Height("肥満型")
    }
}