package com.example.myapplication.Fragment.OCR

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.R

class OCRFragment : BaseFragment() {

    var copyText = ""

    companion object {
        fun newInstance(copyText: String): OCRFragment {
            val fragment = OCRFragment()
            fragment.copyText = copyText
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeHeaderTitle("OCRテスト")
        switchBackButton(this)
        val view = inflater.inflate(R.layout.ocr_fragment, container, false)
        val imgTextView = view.findViewById<TextView>(R.id.img_text)
        imgTextView.text = this.copyText

        var teacherHomeButton = view.findViewById<Button>(R.id.teacher_home_button)
        teacherHomeButton.setOnClickListener(onTeacherHomeClick)
        return view
    }

    val onTeacherHomeClick = View.OnClickListener {
        replaceFragment(TeacherHomeFragment())
    }
}