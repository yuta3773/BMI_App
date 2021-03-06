package com.example.mybmi

import kotlin.math.floor


class BmiCalculation {
    private var height: Double = 0.0
    private var weight: Double = 0.0
    private var bmiResult: Double = 0.0
    private var bmiType = ""

    //身長と体重を受け取りBMI値を計算。戻り値はデータクラス
    fun result(height: String, weight: String ): BmiInfo{
        if (height != "" && weight != "") {
            this.height = height.toDouble()
            this.weight = weight.toDouble()
            bmiResult = this.weight / (this.height * 2 / 100)
            bmiResult
        }
        bmiType = when {
            18.5 > bmiResult -> BmiInfo.Type.Low.type
            25 > bmiResult -> BmiInfo.Type.Middle.type
            else -> BmiInfo.Type.Height.type
        }
        return BmiInfo(floor(bmiResult * 10.0) / 10.0, bmiType)
    }
}

