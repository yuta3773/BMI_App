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

        //クリックすると結果アクティビティに移動
        binding.measurementButton.setOnClickListener {
            val resultBmi = calculation.result(
                    height = binding.heightInputForm.text.toString(),
                    weight = binding.weightInputForm.text.toString()
            )
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("MY_BMI", resultBmi)
            startActivity(intent)
        }

        //クリックすると測定値がリセット（リセット）
        binding.resetButton.setOnClickListener {
            binding.resultBmiOutput.text = null
            binding.weightInputForm.text = null
            binding.heightInputForm.text = null
        }
    }
}