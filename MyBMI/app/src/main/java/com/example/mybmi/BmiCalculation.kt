package com.example.mybmi

class BmiCalculation {

    private var height = 0
    private var weight = 0
    private var bmiResult = 0
    private val bmiIllega = "未入力あり"

    fun result(height: String, weight: String ):String {
        return if (height != "" && weight != "") {
            this.height = height.toInt()
            this.weight = weight.toInt()
            bmiResult = this.weight / (this.height * 2 / 100)
            bmiResult.toString()
        } else {
            bmiIllega
        }
    }
}