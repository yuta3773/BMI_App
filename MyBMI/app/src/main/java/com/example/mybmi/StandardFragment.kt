package com.example.mybmi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mybmi.databinding.FragmentStandardBinding

class StandardFragment(myBmi: String) : Fragment() {
    val bmiNum = myBmi

    //bindingで使用する変数、定数
    private var _binding: FragmentStandardBinding? = null
    private val binding get() = _binding!!

    //フラグメントの画面レイアウトからビューを作成する
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        //inflaterの呼び出し
        _binding = FragmentStandardBinding.inflate(inflater, container, false)

        //standardTextにBMI数値に合わせた文書を入れる
        when {
            18.5 > bmiNum.toInt() -> {
                binding.standardText.setText(R.string.skinny)
            }
            25 > bmiNum.toInt() -> {
                binding.standardText.setText(R.string.standard)
            }
            else -> {
                binding.standardText.setText(R.string.obesity)
            }
        }
        return binding.root
    }
}