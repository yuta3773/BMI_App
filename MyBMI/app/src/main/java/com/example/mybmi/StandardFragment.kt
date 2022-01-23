package com.example.mybmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mybmi.databinding.FragmentStandardBinding

//キーを保持する
private const val BMI_BODY = "BMI_BODY"

class StandardFragment() : Fragment() {

    //arguments(アーギュメンツ)から取り出したものを保持する
    private var bmiBody: BmiInfo? = null


    //フラグメント作成、再作成時に呼び出される
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //本来はgetArgumentsメソッドだがKotlinはargumentsプロパティを使用できる
        arguments?.let {
            //argumentsに保存したものをbmiBodyに保存する
            bmiBody = it.getParcelable<BmiInfo>("BMI_TYPE")
        }
    }

    //viewBindingの設定
    private var _binding: FragmentStandardBinding? = null
    private val binding get() = _binding!!
//    bmiBody = arguments?.getParcelable<BmiInfo>("BMI_TYPE")

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
            //inflaterの呼び出し
        _binding = FragmentStandardBinding.inflate(inflater, container, false)
        when(bmiBody?.type) {
            BmiInfo.Type.Low.type ->
                binding.standardText.setText(R.string.skinny)
            BmiInfo.Type.Middle.type ->
                binding.standardText.setText(R.string.standard)
            BmiInfo.Type.Height.type ->
                binding.standardText.setText(R.string.obesity)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    //コンパニオンオブジェクトの宣言
    companion object {
        //表示する文書をもらう引数にする
        fun newInstance(bmiBody: String) =
            //インスタンスの戻り値にする
            StandardFragment().apply {
                arguments = Bundle().apply {
                    putString("BMI_BODY", bmiBody)
                }
            }
    }
}