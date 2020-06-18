package com.example.myapplication.Fragment.OCR

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Context.OCRUtil
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.R

class OCRFragment : BaseFragment() {

    lateinit var ocrUtil: OCRUtil

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ocr_fragment, container, false)
        val bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test)
        ocrUtil = OCRUtil(activity!!.applicationContext)
        val copyText = ocrUtil.getString(activity!!.applicationContext, bitmap, "jpnnew")
        val imgTextView = view.findViewById<TextView>(R.id.img_text)
        imgTextView.text = copyText

        var teacherHomeButton = view.findViewById<Button>(R.id.teacher_home_button)
        teacherHomeButton.setOnClickListener(onTeacherHomeClick)
        return view
    }

    val onTeacherHomeClick = View.OnClickListener {
        transitionPage(TeacherHomeFragment())
        changeTitle("HOME")
    }
}