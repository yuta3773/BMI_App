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
        binding.nextDetailButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("MY_BMI", binding.resultBmiOutput.text)
            startActivity(intent)
        }

        // クリックすると測定ボタンを押したら測定値がでる
        binding.measurementButton.setOnClickListener {
            binding.resultBmiOutput.text = calculation.result(
                    height = binding.heightInputForm.text.toString(),
                    weight = binding.weightInputForm.text.toString()
            )
        }

        //クリックすると測定値がリセット（リセット）
        binding.resetButton.setOnClickListener {
            binding.resultBmiOutput.text = ""
        }
    }
}