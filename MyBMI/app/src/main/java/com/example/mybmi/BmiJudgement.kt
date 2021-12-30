package com.example.mybmi

class BmiJudgement(val bmiNum: String) {
    fun judgement(): String {
        return when {
            "未入力あり" == bmiNum -> {
                ""
            }
            18.5 > bmiNum.toInt() -> {
                "痩せ型"
            }
            25 > bmiNum.toInt() -> {
                "標準体重"
            }
            else -> {
                "肥満"
            }
        }
    }
}