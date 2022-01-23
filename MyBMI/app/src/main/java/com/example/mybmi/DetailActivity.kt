package com.example.mybmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mybmi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var standardFragment: StandardFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //前画面からBMI数値をもらい、詳細画面に入力
        val myBmi = intent.getParcelableExtra<BmiInfo>("MY_BMI")

        if (myBmi != null) {
            binding.resultDetailBmiOutput.text = myBmi.bmi.toString()

            //前画面からのBMI数値を使い体重判定
            binding.judgementText.text = myBmi.type

            //フラグメントを表示させる
            standardFragment = StandardFragment()
            val bundle = Bundle()
            bundle.putParcelable("BMI_TYPE", myBmi)
            standardFragment.arguments = bundle
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, standardFragment)
                commit()
            }
        }
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}