package com.example.mybmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybmi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var text: StandardFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //前画面からBMI数値をもらい、詳細画面に入力
        val myBmi = intent.getParcelableExtra<BmiInfo>("MY_BMI")
        if (myBmi != null) {
            binding.resultDetailBmiOutput.text = myBmi.bmi.toString()

            //前画面からのBMI数値を使い体重判定
            val judgement = BmiJudgement(myBmi.bmi)
            binding.judgementText.text = judgement.judgement()

            //フラグメントを表示させる
            text = StandardFragment(myBmi)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, text)
                commit()
            }

        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}