package com.example.myapplication.Fragment.OCR

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.R
import com.googlecode.tesseract.android.TessBaseAPI

class OCRFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ocr_fragment, container, false)
        val bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a)
        val baseApi = TessBaseAPI()
        // initで言語データを読み込む
        baseApi.init(activity?.getFilesDir().toString(), "jpn")
        // ギャラリーから読み込んだ画像をFile or Bitmap or byte[] or Pix形式に変換して渡してあげる
        baseApi.setImage(bitmap)
        // これだけで読み取ったテキストを取得できる
        val recognizedText = baseApi.utF8Text


        val imgTextView = view.findViewById<TextView>(R.id.img_text)
        imgTextView.text = recognizedText
        baseApi.end()
        return view
    }
}