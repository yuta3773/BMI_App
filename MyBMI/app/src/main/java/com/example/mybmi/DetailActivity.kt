package com.example.mybmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybmi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //前画面からBMI数値をもらい、詳細画面に入力
        val myBmi = intent.getStringExtra("MY_BMI")
        binding.resultDetailBmiOutput.text = myBmi

        //前画面からのBMI数値を使い体重判定
        val judgement = BmiJudgement(myBmi.toString())
        binding.judgementText.text = judgement.judgement()

        //クリックすると体重判定の結果を元に文章を表示する
        binding.standardButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                if (myBmi != null) {
                    when {
                        "未入力あり" == myBmi -> {
                        }
                        18.5 > myBmi.toInt() -> {
                            replace(R.id.container, SkinnyFragment())
                            addToBackStack(null)
                            commit()
                        }
                        25 > myBmi.toInt() -> {
                            replace(R.id.container, StandardFragment())
                            addToBackStack(null)
                            commit()
                        }
                        else -> {
                            replace(R.id.container, ObesityFragment())
                            addToBackStack(null)
                            commit()
                        }
                    }
                }
            }
        }
        //クリックするとメイン画面に戻る
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}