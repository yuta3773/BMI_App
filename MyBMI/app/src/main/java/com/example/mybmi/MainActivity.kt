package com.example.mybmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //BMIの計算をするクラスをインスタンス化
        val calculation = BmiCalculation()

        //クリックすると詳細アクティビティに移動
        binding.measurementButton.setOnClickListener {
            //未入力だとmeasurementButtonを押せない
            if (binding.heightInputForm.text.toString() != "" && binding.weightInputForm.text.toString() != "") {

                    val result = calculation.result(
                    height = binding.heightInputForm.text.toString(),
                    weight = binding.weightInputForm.text.toString()
                )

                //BmiInfoクラスをインスタンス化
                val bmiInfo = BmiInfo(result.bmi, result.type)
                intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("MY_BMI", bmiInfo)

                startActivity(intent)
            }
        }

        //クリックすると測定値がリセット（リセット）
        binding.resetButton.setOnClickListener {
            binding.weightInputForm.text = null
            binding.heightInputForm.text = null
        }
    }
}