package com.example.mybmi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
//BMI計算結果をプロパティとして持つデータ型にする
data class BmiInfo(
    val bmi: Int) : Parcelable {
    //結果表示。BmiInfoのみで使用の為入れ子
    enum class Type (){
        Low,
        Middle,
        Height
    }
}

